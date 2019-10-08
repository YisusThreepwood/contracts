package contracts

interface Contracts {
    interface PlayerContractMapper {
        fun toEntity(data: String): PlayerContractEntity
    }

    interface PlayerContractGateway {
        fun getCurrentContractFromPlayer(playerId: String): PlayerContractEntity
    }
}