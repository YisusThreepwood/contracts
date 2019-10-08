package contracts

import au.com.dius.pact.provider.junit.Provider
import au.com.dius.pact.provider.junit.State
import au.com.dius.pact.provider.junit.loader.PactFolder
import au.com.dius.pact.provider.junit.target.TestTarget
import au.com.dius.pact.provider.junit5.HttpTestTarget
import au.com.dius.pact.provider.junit5.PactVerificationContext
import au.com.dius.pact.provider.junit5.PactVerificationInvocationContextProvider
import io.micronaut.test.annotation.MicronautTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.TestTemplate
import org.junit.jupiter.api.extension.ExtendWith
import java.net.URL

@MicronautTest
@Provider("Contracts")
@PactFolder("pacts")
class PactVerificationTest {

    @TestTemplate
    @ExtendWith(PactVerificationInvocationContextProvider::class)
    fun pactsVerificationTemplate(context: PactVerificationContext) {
        context.verifyInteraction()
    }

    @BeforeEach
    fun setupContext(context: PactVerificationContext) {
        context.target = HttpTestTarget.fromUrl(URL("http://localhost:8090"))
    }

    @State("Get player's current contract")
    fun testGetPayerCurrentContractInfo(params: Map<String, Object>) {
        val aaa:String = ""
    }
}