package id.ac.ui.cs.mobileprogramming.fijar.ngebola.ui.stopwatch

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.R
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [StopwatchFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StopwatchFragment : Fragment() {
    private var second = 0
    private var isRunning: Boolean = false
    // TODO: Rename and change types of parameters

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            second = savedInstanceState.getInt("second")
            isRunning = savedInstanceState.getBoolean("isRunning")
        }
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        savedInstanceState.putInt("second", second)
        savedInstanceState.putBoolean("isRunning", isRunning)
        super.onSaveInstanceState(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_stopwatch, container, false)
        // Inflate the layout for this fragment
        runTimer(view)
        val startButton = view.findViewById<Button>(R.id.start_button)
        val pauseButton = view.findViewById<Button>(R.id.pause_button)
        val resetButton = view.findViewById<Button>(R.id.reset_button)

        startButton.setOnClickListener {
            onClickStart(it)
        }
        pauseButton.setOnClickListener {
            onClickPause(it)
        }
        resetButton.setOnClickListener {
            onClickReset(it)
        }


        return view
    }
//
//    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param param1 Parameter 1.
//         * @param param2 Parameter 2.
//         * @return A new instance of fragment StopwatchFragment.
//         */
//        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//                StopwatchFragment().apply {
//                    arguments = Bundle().apply {
//                        putString(ARG_PARAM1, param1)
//                        putString(ARG_PARAM2, param2)
//                    }
//                }
//    }

    private fun onClickStart(v: View) {
        Log.d("on click start", "On click start is running")
        isRunning = true
    }

    private fun onClickPause(v: View) {
        isRunning = false
    }

    private fun onClickReset(v: View) {
        isRunning = false
        second = 0
    }

    private fun runTimer(v: View) {
        Log.d("run timer", "Run timer is running")
        val timeView = v.findViewById<TextView>(R.id.time_View)
        val handler = Handler(Looper.getMainLooper())
        handler.post(object: Runnable {
            override fun run() {
                val hours = (second/3600)
                val minutes = (second%3600)/60
                val secs = second%60
                val time = String.format(Locale.getDefault(), "%d:%02d:%02d", hours, minutes, secs)

                timeView?.text = time

                Log.d("DEBUG", time)

                if (isRunning) {
                    second++
                    Log.d("increasing second value", second.toString())
                }
                handler.postDelayed(this, 1000)
            }
        })
    }

}