package contracts

import javax.inject.Singleton
import javax.json.Json
import javax.json.JsonObject

@Singleton
class PlayerContractTransformer {
    fun transform(playerContract: PlayerContractEntity): JsonObject {
        return Json.createObjectBuilder()
            .add("id", playerContract.id)
            .add("club_id", playerContract.clubId)
            .add("player_id", playerContract.playerId)
            .add("end_date", playerContract.endDate.toString())
            .build()
    }
}