package com.my.kotlin.example.demo

import com.example.demo.rest.response.Result
import com.example.demo.service.FirstService
import com.example.demo.service.SecondService
import com.example.demo.service.ThirdService
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.runBlocking

class KotlinServiceAsync(private val firstService: FirstService, private val secondService: SecondService, private val thirdService: ThirdService) { // передаем необходимые сервисы в качестве параметров главного конструктора (можно делать через DI)
    // функциональная запись возвращающая билдер [runBlocking] который заблокирует главный поток, пока корутины внутри не будут выполнены
    fun getResultOfSomethingAsync() = runBlocking {
        // тип будет выведен компилятором в соответствии с типом последнего выражения внутри билдера
        val firstResult = async {
            // запускаем корутину в отдельном потоке и сохраняем ссылку в переменную
            firstService.longCalculation() // Этот код будет запущен в отдельном потоке, также последнее выражение будет возвращено неявно
        }

        val secondResult = async {
            secondService.veryLongCalculation()
        }

        val thirdResult = async {
            thirdService.longestCalculation()
        }

        Result(firstResult.await(), secondResult.await(), thirdResult.await())
        // ждем пока все корутины выполнится и неявно возвращаем результат
    }
}