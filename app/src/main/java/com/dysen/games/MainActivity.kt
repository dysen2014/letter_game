package com.dysen.games

import android.os.Bundle
import android.view.Gravity
import android.view.KeyEvent
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.dysen.games.base_recycler_adapter.SuperRecyclerAdapter
import com.dysen.games.base_recycler_adapter.SuperRecyclerHolder
import com.dysen.games.data.CommonBaen
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_top.*

class MainActivity : AppCompatActivity() {
    var data1 = mutableListOf<CommonBaen>()
    var data2 = mutableListOf<CommonBaen>()
    var data3 = mutableListOf<CommonBaen>()
    var dataA = mutableListOf<String>()
    var dataB = mutableListOf<String>()
    var temp: MutableMap<String, String> = mutableMapOf()
    var mAdapter1: SuperRecyclerAdapter<CommonBaen>? = null
    var mAdapter2: SuperRecyclerAdapter<CommonBaen>? = null
    var mAdapter3: SuperRecyclerAdapter<CommonBaen>? = null
    var mAdapterA: SuperRecyclerAdapter<String>? = null
    var mAdapterB: SuperRecyclerAdapter<String>? = null

    var contestantFlag = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        initAdapter()
        initClick()
        initData()
    }

    private fun initAdapter() {

        mAdapter1 = object : SuperRecyclerAdapter<CommonBaen>(this) {
            override fun convert(
                holder: SuperRecyclerHolder?, t: CommonBaen?, layoutType: Int, position: Int
            ) {
                holder?.apply {
                    t?.let { t ->
                        setText(R.id.tv_name, t.name)
                        setTextColor(
                            R.id.tv_name,
                            if (t.isChecked) resources.getColor(R.color.text_color_red) else resources.getColor(
                                R.color.text_color_black
                            )
                        )
                        setBackgroundResource(
                            R.id.tv_name,
                            if (t.isChecked) R.drawable.bg_shape_red else R.drawable.bg_shape_gray
                        )
                        setOnItemClickListenner {
                            if (temp.isNotEmpty()&&temp.keys.filter { !it.contains("0-") }.toMutableList().isNotEmpty())
                                showTip("不能跨行选择！")
                            else {
                                data1[position].isChecked = !t.isChecked
                                if (t.isChecked)
                                    temp["0-$position"] = t.name
                                else
                                    temp.remove("0-$position")
                                mAdapter1?.notifyDataSetChanged()
                            }
                        }
                    }
                }
            }

            override fun getLayoutAsViewType(t: CommonBaen?, position: Int): Int {
                return R.layout.layout_item
            }
        }
        mAdapter2 = object : SuperRecyclerAdapter<CommonBaen>(this) {
            override fun convert(
                holder: SuperRecyclerHolder?, t: CommonBaen?, layoutType: Int, position: Int
            ) {
                holder?.apply {
                    t?.let { t ->
                        setText(R.id.tv_name, t.name)
                        setTextColor(
                            R.id.tv_name,
                            if (t.isChecked) resources.getColor(R.color.text_color_red) else resources.getColor(
                                R.color.text_color_black
                            )
                        )
                        setBackgroundResource(
                            R.id.tv_name,
                            if (t.isChecked) R.drawable.bg_shape_red else R.drawable.bg_shape_gray
                        )
                        setOnItemClickListenner {
                            if (temp.isNotEmpty()&&temp.keys.filter { !it.contains("1-") }.toMutableList().isNotEmpty())
                                showTip("不能跨行选择！")
                            else {
                                data2[position].isChecked = !t.isChecked
                                if (t.isChecked)
                                    temp["1-$position"] = t.name
                                else
                                    temp.remove("1-$position")
                                mAdapter2?.notifyDataSetChanged()
                            }
                        }
                    }
                }
            }

            override fun getLayoutAsViewType(t: CommonBaen?, position: Int): Int {
                return R.layout.layout_item
            }
        }
        mAdapter3 = object : SuperRecyclerAdapter<CommonBaen>(this) {
            override fun convert(
                holder: SuperRecyclerHolder?, t: CommonBaen?, layoutType: Int, position: Int
            ) {
                holder?.apply {
                    t?.let { t ->
                        setText(R.id.tv_name, t.name)

                        setTextColor(
                            R.id.tv_name,
                            if (t.isChecked) resources.getColor(R.color.text_color_red) else resources.getColor(
                                R.color.text_color_black
                            )
                        )
                        setBackgroundResource(
                            R.id.tv_name,
                            if (t.isChecked) R.drawable.bg_shape_red else R.drawable.bg_shape_gray
                        )
                        setOnItemClickListenner {
                            if (temp.isNotEmpty() && temp.keys.filter { !it.contains("2-") }
                                    .toMutableList().isNotEmpty())
                                showTip("不能跨行选择！")
                            else {
                                data3[position].isChecked = !t.isChecked
                                if (t.isChecked)
                                    temp["2-$position"] = t.name
                                else
                                    temp.remove("2-$position")
                                mAdapter3?.notifyDataSetChanged()
                            }
                        }
                    }
                }
            }

            override fun getLayoutAsViewType(t: CommonBaen?, position: Int): Int {
                return R.layout.layout_item
            }
        }
        mAdapterA = object : SuperRecyclerAdapter<String>(this) {
            override fun convert(
                holder: SuperRecyclerHolder?, t: String?, layoutType: Int, position: Int
            ) {
                holder?.apply {
                    t?.let { t ->
                        setText(R.id.tv_name, t)

                        setTextColor(
                            R.id.tv_name, resources.getColor(R.color.appBlue)
                        )
                    }
                }
            }

            override fun getLayoutAsViewType(t: String?, position: Int): Int {
                return R.layout.layout_item
            }
        }
        mAdapterB = object : SuperRecyclerAdapter<String>(this) {
            override fun convert(
                holder: SuperRecyclerHolder?, t: String?, layoutType: Int, position: Int
            ) {
                holder?.apply {
                    t?.let { t ->
                        setText(R.id.tv_name, t)
                        setTextColor(
                            R.id.tv_name, resources.getColor(R.color.appGreen)
                        )
                    }
                }
            }

            override fun getLayoutAsViewType(t: String?, position: Int): Int {
                return R.layout.layout_item
            }
        }

        rcl_1.layoutManager = StaggeredGridLayoutManager(5, LinearLayoutManager.VERTICAL)
        rcl_2.layoutManager = StaggeredGridLayoutManager(5, LinearLayoutManager.VERTICAL)
        rcl_3.layoutManager = StaggeredGridLayoutManager(5, LinearLayoutManager.VERTICAL)
        rcl_a.layoutManager = StaggeredGridLayoutManager(4, LinearLayoutManager.VERTICAL)
        rcl_b.layoutManager = StaggeredGridLayoutManager(4, LinearLayoutManager.VERTICAL)

        rcl_1.adapter = mAdapter1
        rcl_2.adapter = mAdapter2
        rcl_3.adapter = mAdapter3
        rcl_a.adapter = mAdapterA
        rcl_b.adapter = mAdapterB
    }

    private fun initClick() {
        btn_submit.setOnClickListener {
            if (!contestantFlag) {//选手A
                dataA.addAll(temp.values)
                mAdapterA?.setDatas(dataA)
            } else {//选手B
                dataB.addAll(temp.values)
                mAdapterB?.setDatas(dataB)
            }
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                temp.forEach { i, v ->
                    data1 = data1.filter { it.name != v }.toMutableList()
                    mAdapter1?.setDatas(data1)
                    data2 = data2.filter { it.name != v }.toMutableList()
                    mAdapter2?.setDatas(data2)
                    data3 = data3.filter { it.name != v }.toMutableList()
                    mAdapter3?.setDatas(data3)
                }
            }
            if (dataA.size + dataB.size > 14)
                showTip("${tv_title.text}\n您输了😭😭😭", Toast.LENGTH_LONG)
            else
                tv_title.text = "选手${if (contestantFlag) "A" else "B"}"

            contestantFlag = !contestantFlag
            temp.clear()

        }
        btn_reset.setOnClickListener { initData() }

    }

    private fun initData() {
        data1.clear()
        data2.clear()
        data3.clear()
        dataA.clear()
        dataB.clear()
        for (i in 1..3) {
            data1.add(CommonBaen(false, "$i"))
        }
        for (i in 4..8) {
            data2.add(CommonBaen(false, "$i"))
        }
        for (i in 9..15) {
            data3.add(CommonBaen(false, "$i"))
        }
        mAdapter1?.setDatas(data1)
        mAdapter2?.setDatas(data2)
        mAdapter3?.setDatas(data3)
        mAdapterA?.setDatas(dataA)
        mAdapterB?.setDatas(dataB)
    }

    private fun initView() {
        tv_back.visibility = View.INVISIBLE
        tv_title.text = "选手A"
    }

    fun showTip(content: String, duration: Int = Toast.LENGTH_SHORT) {
        val makeText = Toast.makeText(this, content, duration)
        makeText.setGravity(Gravity.CENTER, 0, 0)
        makeText.show()
    }

    //记录用户首次点击返回键的时间
    private var firstTime: Long = 0

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            val secondTime = System.currentTimeMillis()
            if (secondTime - firstTime > 2000) {
                showTip("再按一次退出程序")
                firstTime = secondTime
                return true
            } else {
                System.exit(0)
            }
            return true //不执行父类点击事件
        }
        return super.onKeyDown(keyCode, event) //继续执行父类其他点击事件
    }
}