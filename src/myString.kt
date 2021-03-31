class myString {

    private lateinit var data:MutableList<Char>

    constructor(str: String) {
       this.data = str.toMutableList()
    }

    constructor(n: Int){
        this.data = n.toString().toMutableList()
    }

    override fun toString() :String {
        return this.data.joinToString("")
    }

    fun concat(newData :myString, isEnd :Boolean = true) :myString {

        if (isEnd)
            this.data.addAll(newData.data)
        else
            this.data.addAll(0, newData.data)
        return this
    }

    fun substr(len :Int, offset :Int = 0) :myString{

        val newData :MutableList<Char> = mutableListOf()
        for(i in offset until len + offset) {
            newData.add(this.data[i])
        }

        this.data = newData
        return this
    }

    fun find(pattern :myString) :Int{
        val maxIndex = this.data.size - 1
        external@ for(i in 0 until this.data.size){
            var j = i
            for (findElement in pattern.data){
                if (j > maxIndex) break@external
                if (this.data[j] != findElement) continue@external
                j++
            }
            return i
        }
        return -1
    }

    fun toFloat() :Float {

        if(this.data.isEmpty()) return  0.0f

        if (!this.data[0].isDigit() && this.data[0] != '-') return 0.0f

        val dataFloat :MutableList<Char> = mutableListOf(this.data[0])
        var countDigit = if (this.data[0].isDigit()) 1 else 0

        for(i in 1 until this.data.size){

            if(countDigit == 9) break

            if (!this.data[i].isDigit() && this.data[i] != '.') break

            if(this.data[i].isDigit())
                countDigit++

            dataFloat.add(this.data[i])
        }

        this.data = dataFloat
        return toString().toFloat()
    }
}
