package id.ac.ui.cs.mobileprogramming.fijar.ngebola.external

class AgeCategory {
    @Throws(IllegalArgumentException::class)
    external fun categorizedAge(age: Int): Int

    companion object {
        init {
            System.loadLibrary("categorization-c")
        }
    }
}