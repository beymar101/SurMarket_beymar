package bo.edu.uajms.beymarchoque.surmarket

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class FragmentLogin : Fragment() {
    private lateinit var EXT_FRGLogin_UserName: EditText
    private lateinit var EXT_FRGLogin_Pasaword: EditText
    private lateinit var TXv_FRGLogin_RecoverPassword: TextView
    private lateinit var BTN_FRGLogin_Login: Button
    private lateinit var BTN_FRGLogin_Register: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initalizeView(view)
        configureListeners()
    }

    private fun initalizeView(view: View) {
        EXT_FRGLogin_UserName = view.findViewById(R.id.ETX_FRGLOgin_UserName)
        EXT_FRGLogin_Pasaword = view.findViewById(R.id.ETX_FRGLOgin_UserName)
        TXv_FRGLogin_RecoverPassword = view.findViewById(R.id.TXVFRGLogin_RecoverPassword)
        BTN_FRGLogin_Login = view.findViewById(R.id.BTN_FRGLogin_Login)
        BTN_FRGLogin_Register = view.findViewById(R.id.BTN_FRGLogin_Register)

    }

    private fun configureListeners() {
        TXv_FRGLogin_RecoverPassword.setOnClickListener() {

        }
        BTN_FRGLogin_Login.setOnClickListener() {
            SignIn()
        }
        BTN_FRGLogin_Register.setOnClickListener() {

        }
    }
    private fun SignIn(){
        val user = EXT_FRGLogin_UserName.text.toString().trim()
        val password = EXT_FRGLogin_Pasaword.text.toString().trim()
        if(!verifyIntegrity(user,password))
        {
            return
        }
        if (verifyCredentials(user,password)){
            Toast.makeText(requireContext(),getString(R.string.loginWelcome), Toast.LENGTH_SHORT).show()
        }
        else
        {
            Toast.makeText(requireContext(),getString(R.string.loginError), Toast.LENGTH_SHORT).show()
        }
    }



    private fun verifyIntegrity(user: String, password: String): Boolean {
        var res = true
        if(user.isEmpty())
        {
            EXT_FRGLogin_UserName.error = getString(R.string.userEmpty)
        }
        else
        {
            EXT_FRGLogin_UserName.error = null
        }
        if(password.isEmpty())
        {
            EXT_FRGLogin_Pasaword.error = getString(R.string.passwordEmpty)
        }
        else
        {
            EXT_FRGLogin_Pasaword.error = null
        }
        return res
    }

    private fun verifyCredentials(user: String, password: String): Boolean {
        return user== "admin" && password=="123456"
    }

}
