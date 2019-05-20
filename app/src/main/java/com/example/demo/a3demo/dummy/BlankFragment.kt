package com.example.demo.a3demo.dummy

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.demo.a3demo.BookDetailActivity
import com.example.demo.a3demo.MapsActivity

import com.example.demo.a3demo.R
import kotlinx.android.synthetic.*
import java.util.*
import javax.xml.datatype.DatatypeConstants.MONTHS

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [BlankFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class BlankFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

    private lateinit var button: Button
    private lateinit var destination: EditText
    private lateinit var pickUpPoint: EditText
    private lateinit var noOfPeople: EditText
    private lateinit var progressBar: ProgressBar
    private lateinit var datePicker:  EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button = getView()?.findViewById(R.id.button) as Button
        destination = getView()?.findViewById(R.id.editText) as EditText
        pickUpPoint = getView()?.findViewById(R.id.editText3) as EditText
        noOfPeople = getView()?.findViewById(R.id.editText2) as EditText
        progressBar = getView()?.findViewById(R.id.indeterminateBar) as ProgressBar
        datePicker = getView()?.findViewById(R.id.editText4) as EditText

        val c = Calendar.getInstance()

        datePicker.setOnClickListener {
            var dateDialog = DatePickerDialog(this.context, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->

                // Display Selected date in textbox
                Toast.makeText(this.context, "You have clicked me date", Toast.LENGTH_LONG).show()
                datePicker.setText("$dayOfMonth/$monthOfYear/$year")
//                datePicker.setText("2/8/19")
            }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH))
            dateDialog.show()
        }

        button.setOnClickListener {
//            Toast.makeText(this.context, "You have clicked me", Toast.LENGTH_LONG).show()
            progressBar.visibility = View.VISIBLE

            Handler().postDelayed({
                progressBar.visibility = View.GONE
                var intent = Intent(this.context, BookDetailActivity::class.java)
                intent.putExtra("destination", destination.text.toString())
                intent.putExtra("pickUpPoint", pickUpPoint.text.toString())
                intent.putExtra("noOfPeople", noOfPeople.text.toString())
                intent.putExtra("date", datePicker.text.toString())
//                var intent = Intent(this.context, MapsActivity::class.java)
                startActivity(intent)

            }, 4000);
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        if (context is OnFragmentInteractionListener) {
//            listener = context
//        } else {
//            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
//        }
//    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BlankFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BlankFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
