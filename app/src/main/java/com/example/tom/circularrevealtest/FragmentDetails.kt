package com.example.tom.circularrevealtest

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class FragmentDetails : Fragment(), Dismissible {

    companion object {
        const val ARG_REVEAL_SETTINGS = "arg_reveal_settings"
        fun newInstance(revealSettings: RevealAnimationSetting) = FragmentDetails().withArgs { it.putParcelable(ARG_REVEAL_SETTINGS, revealSettings) }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_details, container, false)
        view.registerCircularRevealAnimation(arguments!!.getParcelable(ARG_REVEAL_SETTINGS),
                resources.getColor(R.color.primary, null),
                resources.getColor(R.color.white, null))
        return view
    }

    override fun dismiss(listener: Dismissible.OnDismissedListener) {
        view!!.startCircularExitAnimation(arguments!!.getParcelable(ARG_REVEAL_SETTINGS) as RevealAnimationSetting,
                resources.getColor(R.color.white, null),
                resources.getColor(R.color.primary, null),
                object : Dismissible.OnDismissedListener {
                    override fun onDismissed() {
                        view!!.visibility = View.GONE
                        listener.onDismissed()
                    }
                })
    }

}