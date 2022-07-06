package graphql

import cats.effect.unsafe.implicits.global
import model.{Alcaldia, Estado, Unidad}
import repository.{RepoMbMx, RepoMbMxImpl}
import sangria.macros.derive.{AddFields, deriveObjectType}
import sangria.schema._
object SangriaGraphql {


  val EstadoType = ObjectType("Estado",
    fields[Unit, Estado](
      Field("id", IntType, resolve = _.value.id),
      Field("description", StringType, resolve = _.value.description)
    )
  )
  val Id = Argument("id", IntType)
  val IdEstatus = Argument("id", IntType)
  val Descripcion = Argument("description", StringType)
  val Ids = Argument("ids", ListInputType(IntType))


  implicit  lazy val AlcaldiaType: ObjectType[RepoMbMx, Alcaldia] = deriveObjectType[RepoMbMx, Alcaldia](
    AddFields(
      Field("unidades",ListType(UnidadType),resolve = c => c.ctx.findUnidadesByIdAlcaldia2(c.value.id).unsafeRunSync())
    )
  )

  implicit lazy val UnidadType: ObjectType[RepoMbMx, Unidad]  = deriveObjectType[RepoMbMx, Unidad](
    AddFields(
      Field("alcaldias",ListType(AlcaldiaType),resolve = c => c.ctx.findAlcaldiaByIdVehiculo2(c.value.id).unsafeRunSync())
    )
  )



  val QueryType  = ObjectType("Query", "consultas",
    fields[RepoMbMx, Unit](
      Field( "estado", EstadoType,
        description = Some("Entrega un estatus x id"),
        arguments = IdEstatus :: Nil,
        resolve = ctx => ctx.ctx.findEstadoById(ctx.arg(IdEstatus))
      ),
      Field( "allEstados", ListType(EstadoType),
        description = Some("Entrega el listado de estatus existentes"),
        resolve = ctx => ctx.ctx.findAllEstado()
      ),
      Field( "alcaldia", AlcaldiaType,
        description = Some("Entrega una alcaldia x id"),
        arguments = IdEstatus :: Nil,
        resolve = ctx => ctx.ctx.findAlcaldiaById(ctx.arg(IdEstatus))
      ),
      Field( "allAlcaldias", ListType(AlcaldiaType),
        description = Some("Entrega el listado de alcaldias existentes"),
        resolve = ctx => ctx.ctx.findAllAlcaldia()
      ),
      Field( "unidad", UnidadType,
        description = Some("Entrega un unidad x id"),
        arguments = IdEstatus :: Nil,
        resolve = ctx => ctx.ctx.findUnidadById(ctx.arg(IdEstatus))
      ),
      Field( "allUnidades", ListType(UnidadType),
        description = Some("Entrega el listado de unidades existentes"),
        resolve = ctx =>ctx.ctx.findAllUnidades()
      ),
      Field( "alcaldias", ListType(AlcaldiaType),
        description = Some("Entrega el listado de alcaldias existentes"),
        arguments = List(Ids),
        resolve = ctx => ctx.ctx.findAlcaldiaByIds(ctx.arg(Ids))
      ),
      Field( "unidades", ListType(UnidadType),
        description = Some("Entrega el listado de unidades existentes"),
        arguments = List(Ids),
        resolve = ctx =>ctx.ctx.findUnidadesByIds(ctx.arg(Ids))
      )
    )
  )



  val MutationType  = ObjectType( "MutationType","Actualizaciones a BD",
    fields[Unit, Unit](
      Field( "addEstado", IntType,
        description = Some("Añade un estado"),
        arguments = Descripcion :: Nil,
        resolve = sangriaContext => new RepoMbMxImpl().saveEstatusAutoGenerated(sangriaContext.arg(Descripcion))
      )
    )
  )

  val SchemaEstado  = Schema(QueryType)

}


