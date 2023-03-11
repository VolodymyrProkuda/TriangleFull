package com.example.trianglefull

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import com.example.trianglefull.databinding.ActivityMainBinding
import kotlin.math.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonCalc.setOnClickListener { calc() }
        binding.buttonClear.setOnClickListener { funClear() }
      //  binding.editTextA.addTextChangedListener { disableA() }
        binding.editTextB.addTextChangedListener { disableB() }
        binding.editTextC.addTextChangedListener { disableC() }
        binding.editTextAlpha.addTextChangedListener { disableAlpha() }
        binding.editTextBeta.addTextChangedListener { disableBeta() }
        binding.editTextGamma.addTextChangedListener { disableGamma() }

        binding.editTextRbig.isEnabled = false
        binding.editTextRlittle.isEnabled = false

    }
 /*   fun disableA() {
        if (binding.editTextA.text.toString() != "")  binding.editTextGamma.isEnabled = false
        else  binding.editTextGamma.isEnabled = true
    }*/
    fun disableB() {
        if (binding.editTextB.text.toString() != "")  {
            binding.editTextBeta.isEnabled = false
       //     binding.editTextGamma.isEnabled = false
            binding.editTextRbig.isEnabled = false
            binding.editTextRlittle.isEnabled = false
        }
        else  {
            binding.editTextBeta.isEnabled = true
        //    binding.editTextGamma.isEnabled = true
            binding.editTextRbig.isEnabled = true
            binding.editTextRlittle.isEnabled = true
        }
    }
    fun disableC() {
        if (binding.editTextC.text.toString() != "")  {
            binding.editTextAlpha.isEnabled = false
            binding.editTextBeta.isEnabled = false
            binding.editTextGamma.isEnabled = false
            binding.editTextRbig.isEnabled = false
            binding.editTextRlittle.isEnabled = false
        }
        else  {
            binding.editTextAlpha.isEnabled = true
            binding.editTextBeta.isEnabled = true
            binding.editTextGamma.isEnabled = true
            binding.editTextRbig.isEnabled = true
            binding.editTextRlittle.isEnabled = true
        }
    }
    fun disableAlpha() {
        if (binding.editTextAlpha.text.toString() != "")  {
            binding.editTextC.isEnabled = false
          //  binding.editTextBeta.isEnabled = false
            binding.editTextGamma.isEnabled = false
            binding.editTextRbig.isEnabled = false
            binding.editTextRlittle.isEnabled = false
        }
        else  {
            binding.editTextC.isEnabled = true
         //   binding.editTextBeta.isEnabled = true
            binding.editTextGamma.isEnabled = true
            binding.editTextRbig.isEnabled = true
            binding.editTextRlittle.isEnabled = true
        }
    }
    fun disableBeta() {
        if (binding.editTextBeta.text.toString() != "")  {
            binding.editTextC.isEnabled = false
         //   binding.editTextB.isEnabled = false
         //   binding.editTextAlpha.isEnabled = false
            binding.editTextRbig.isEnabled = false
            binding.editTextRlittle.isEnabled = false
        }
        else  {
            binding.editTextC.isEnabled = true
         //   binding.editTextB.isEnabled = true
        //    binding.editTextAlpha.isEnabled = true
            binding.editTextRbig.isEnabled = true
            binding.editTextRlittle.isEnabled = true
        }
    }
    fun disableGamma() {
        if (binding.editTextGamma.text.toString() != "")  {
            binding.editTextC.isEnabled = false
            binding.editTextB.isEnabled = false
            binding.editTextAlpha.isEnabled = false
            binding.editTextRbig.isEnabled = false
            binding.editTextRlittle.isEnabled = false
        }
        else  {
            binding.editTextC.isEnabled = true
            binding.editTextB.isEnabled = true
            binding.editTextAlpha.isEnabled = true
            binding.editTextRbig.isEnabled = true
            binding.editTextRlittle.isEnabled = true
        }
    }
    private fun calc() {
        var typeOfCalculate = 0
        var  allArg = AllArguments()
        if (binding.editTextA.text.toString() != "") {
            allArg.a = binding.editTextA.text.toString().toDouble()
            typeOfCalculate +=2
        }
        if (binding.editTextB.text.toString() != "") {
            allArg.b = binding.editTextB.text.toString().toDouble()
            typeOfCalculate +=4
        }
        if (binding.editTextC.text.toString() != "") {
            allArg.c = binding.editTextC.text.toString().toDouble()
            typeOfCalculate +=8
        }
        if (binding.editTextAlpha.text.toString() != "") {
            allArg.alpha = binding.editTextAlpha.text.toString().toDouble()
            typeOfCalculate +=16
        }
        if (binding.editTextBeta.text.toString() != "") {
            allArg.beta = binding.editTextBeta.text.toString().toDouble()
            typeOfCalculate +=32
        }
        if (binding.editTextGamma.text.toString() != "") {
            allArg.gamma = binding.editTextGamma.text.toString().toDouble()
            typeOfCalculate +=64
        }
        if (binding.editTextRbig.text.toString() != "") {
            allArg.r_big = binding.editTextRbig.text.toString().toDouble()
            typeOfCalculate +=128
        }
        if (binding.editTextRlittle.text.toString() != "") {
            allArg.r_little = binding.editTextRlittle.text.toString().toDouble()
            typeOfCalculate +=256
        }
        if (typeOfCalculate == 2+4+8){
           allArg = calcIfIsabc ( allArg.a,  allArg.b, allArg.c)
        }
        if (typeOfCalculate == 2+4+64){
            allArg = calcIfabgamma (   allArg.a, allArg.b, allArg.gamma*PI/180)
        }
        if (typeOfCalculate == 2+4+16){
            allArg = calcIfabalpha (   allArg.a, allArg.b, allArg.alpha*PI/180)
        }
        if (typeOfCalculate == 2+32+64){
            allArg = calcIfabetagamma (   allArg.a, allArg.beta*PI/180, allArg.gamma*PI/180)
        }
        if (typeOfCalculate == 2+16+32){
            allArg = calcIfaalphabeta (   allArg.a, allArg.alpha*PI/180, allArg.beta*PI/180)
        }
        if (typeOfCalculate != 0) {
            binding.editTextA.setText("%.3f".format(allArg.a))
            binding.editTextB.setText("%.3f".format(allArg.b))
            binding.editTextC.setText("%.3f".format(allArg.c))
            binding.editTextAlpha.setText("%.3f".format(allArg.alpha * 180 / PI))
            binding.editTextBeta.setText("%.3f".format(allArg.beta * 180 / PI))
            binding.editTextGamma.setText("%.3f".format(allArg.gamma * 180 / PI))
            binding.editTextRbig.setText("%.3f".format(allArg.r_big))
            binding.editTextRlittle.setText("%.3f".format(allArg.r_little))
        }

    }
    fun calcIfIsabc (a:Double,b:Double,c:Double): AllArguments {
        //три стороны
        val p = (a+b+c)/2
        val  allArg = AllArguments()
        allArg.a = a
        allArg.b = b
        allArg.c = c
        allArg.alpha = acos( (b* b +  c* c - a*a)/(2*b*c))
        allArg.beta = acos( (a* a +  c* c - b*b)/(2*a*c))
        allArg.gamma = acos( (b* b +  a* a - c*c)/(2*b*a))
        allArg.r_big = allArg.a/sin(allArg.alpha)/2
        allArg.r_little = sqrt((p-a)*(p-b)*(p-c)/p)
        return allArg
    }
    fun calcIfabgamma (a: Double, b: Double, gamma: Double): AllArguments {
        //две стороны и угол между ними
        val  allArg = AllArguments()
        var c: Double
        allArg.gamma = gamma
        allArg.b = b
        allArg.a = a
        allArg.c = sqrt(b*b+a*a-2*b*a*cos(gamma))
        c = allArg.c
        val p = (a+b+c)/2
        allArg.alpha = acos( (b* b +  c* c - a*a)/(2*b*c))
        allArg.gamma = acos( (b* b +  a* a - c*c)/(2*b*a))
        allArg.r_big = allArg.a/sin(allArg.alpha)/2
        allArg.r_little = sqrt((p-a)*(p-b)*(p-c)/p)
        return allArg
    }
    fun calcIfabalpha (a: Double, b: Double, alpha: Double): AllArguments {
        //две стороны и угол у одной из них
        val  allArg = AllArguments()
        var c: Double
        allArg.alpha = alpha
        allArg.b = b
        allArg.a = a
        allArg.beta = asin(sin(alpha)/a*b)
        allArg.gamma = PI -  allArg.beta - alpha
        allArg.c = sqrt(b*b+a*a-2*b*a*cos(allArg.gamma))
        c = allArg.c
        val p = (a+b+c)/2
        allArg.r_big = allArg.a/sin(allArg.alpha)/2
        allArg.r_little = sqrt((p-a)*(p-b)*(p-c)/p)
        return allArg
    }
    fun calcIfabetagamma (a: Double, beta: Double, gamma: Double): AllArguments {
        //сторона и два угла прилежащих
        val  allArg = AllArguments()
        var b: Double
        var c: Double
        allArg.beta = beta
        allArg.a = a
        allArg.gamma = gamma
        allArg.alpha = PI -  gamma - beta
        allArg.b = a/sin(allArg.alpha)*sin(beta)
        allArg.c = a/sin(allArg.alpha)*sin(gamma)
        b = allArg.b
        c = allArg.c
        val p = (a+b+c)/2
        allArg.r_big = allArg.a/sin(allArg.alpha)/2
        allArg.r_little = sqrt((p-a)*(p-b)*(p-c)/p)
        return allArg
    }
    fun calcIfaalphabeta (a: Double, alpha: Double, beta: Double): AllArguments {
        //сторона и два угла прилежащий и противолежащий
        val  allArg = AllArguments()
        var b: Double
        var c: Double
        allArg.beta = beta
        allArg.a = a
        allArg.alpha = alpha
        allArg.gamma = PI -  alpha - beta
        allArg.b = a/sin(allArg.alpha)*sin(beta)
        allArg.c = a/sin(allArg.alpha)*sin(allArg.gamma)
        b = allArg.b
        c = allArg.c
        val p = (a+b+c)/2
        allArg.r_big = allArg.a/sin(allArg.alpha)/2
        allArg.r_little = sqrt((p-a)*(p-b)*(p-c)/p)
        return allArg
    }


  /*  fun calcIfar_bigr_little (a: Double, r_big: Double, r_little: Double): AllArguments{
        //радиусы вписаной и описаной и одна сторона
        val  allArg = AllArguments()
        allArg.a = a
        allArg.r_big = r_big
        allArg.r_little = r_little
        allArg.alpha = asin(allArg.a/allArg.r_big/2)


        return allArg
    }*/
  /*  fun calcIfabetar_big (a: Double, beta: Double, r_big: Double): AllArguments{
        //сторона, угол рядом с ней и радиус описанной
        val  allArg = AllArguments()

        return allArg
    }
    fun calcIfabr_little (a: Double, b: Double, r_little: Double): AllArguments{
        //две стороны и радиус вписанной
        val  allArg = AllArguments()


        return allArg
    }*/


    fun funClear() {
        binding.editTextA.text.clear()
        binding.editTextB.text.clear()
        binding.editTextC.text.clear()
        binding.editTextAlpha.text.clear()
        binding.editTextBeta.text.clear()
        binding.editTextGamma.text.clear()
        binding.editTextRbig.text.clear()
        binding.editTextRlittle.text.clear()

        binding.editTextRbig.isEnabled = false
        binding.editTextRlittle.isEnabled = false

    }

}
class AllArguments() {
    var a: Double = 0.0
    var b: Double = 0.0
    var c: Double = 0.0
    var alpha: Double= 0.0
    var beta: Double= 0.0
    var gamma: Double= 0.0
    var r_big: Double= 0.0
    var r_little: Double= 0.0
}