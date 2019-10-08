package contracts

import java.time.LocalDate
import javax.inject.Singleton

@Singleton
class CsvPlayerContractMapper: Contracts.PlayerContractMapper {
    companion object {
        const val ID_INDEX = 0
        const val PLAYER_ID_INDEX = 1
        const val CLUB_ID_INDEX = 2
        const val END_DATE_INDEX = 3
    }

    override fun toEntity(data: String): PlayerContractEntity {
        var tokens = data.split(',')
        return PlayerContractEntity(
            tokens[ID_INDEX],
            tokens[PLAYER_ID_INDEX],
            tokens[CLUB_ID_INDEX],
            LocalDate.parse(tokens[END_DATE_INDEX])
        )
    }
}