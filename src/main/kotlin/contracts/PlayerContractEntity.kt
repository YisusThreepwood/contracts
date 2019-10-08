package contracts

import java.time.LocalDate

data class PlayerContractEntity (
        var id: String = "",
        var playerId: String = "",
        var clubId: String = "",
        var endDate: LocalDate? = null
) {

}