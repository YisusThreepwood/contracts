package contracts

import io.micronaut.context.annotation.Value
import java.io.BufferedReader
import java.io.FileReader
import java.lang.Exception
import java.nio.file.Paths
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CsvPlayerContractGateway @Inject
constructor(private val playerContractMapper: Contracts.PlayerContractMapper): Contracts.PlayerContractGateway
{
    @Value("\${data.relative-path}")
    private lateinit var dataPath: String;

    override fun getCurrentContractFromPlayer(playerId: String): PlayerContractEntity {
        val reader = BufferedReader(FileReader(
            Paths.get("").toAbsolutePath().toString() + '/' + this.dataPath + "/players_contracts.csv"
        ))
        val line = findLineByPlayerId(reader.lines().toArray(), playerId)

        return playerContractMapper.toEntity(line)
    }

    private fun findLineByPlayerId(lines: Array<Any>, playerId: String): String {
        var lineIndex: Int? = null

        for (i in 0 until lines.size) {
            var data = lines[i].toString().split(',')
            if (data[CsvPlayerContractMapper.PLAYER_ID_INDEX] == playerId) {
                lineIndex = i
            }
        }

        if (lineIndex === null) {
            throw Exception("Contract not found for player $playerId")
        }

        return lines[lineIndex].toString()
    }
}
