package contracts

import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Consumes
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import javax.inject.Inject

@Controller("/contract")
class PlayerContractController @Inject
constructor(
    private val playerContractInteractor: PlayerContractInteractor,
    private val playerContractTransformer: PlayerContractTransformer
) {

    @Get("/current/{playerId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun showCurrentContract(playerId: String): HttpResponse<Any?> {
        return HttpResponse.ok(
            playerContractTransformer
                .transform(playerContractInteractor.getCurrentContractFromPlayerId(playerId))
                .toString()
        )
    }
}
