package com.example.tom.circularrevealtest

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_main.*


class FragmentMain : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        btnDetails.setOnClickListener {
            fragmentManager!!.beginTransaction()
                    .add(R.id.containerMain, FragmentDetails.newInstance(
                            RevealAnimationSetting(
                                    (btnDetails.x + btnDetails.width / 2).toInt(),
                                    (btnDetails.y + btnDetails.height / 2).toInt(),
                                    view.width, view.height)))
                    .addToBackStack(null)
                    .commit()
        }
    }

}