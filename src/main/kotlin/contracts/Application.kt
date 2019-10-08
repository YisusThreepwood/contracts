package contracts

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
            .packages("contracts")
            .mainClass(Application.javaClass)
            .environmentPropertySource(false)
            .start()
    }
}