package contracts

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlayerContractInteractor @Inject
constructor(private val gateway: Contracts.PlayerContractGateway)
{
    fun getCurrentContractFromPlayerId(playerId: String): PlayerContractEntity {
        return gateway.getCurrentContractFromPlayer(playerId)
    }
}