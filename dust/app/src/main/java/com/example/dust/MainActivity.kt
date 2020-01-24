package com.example.dust

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Attr
import org.w3c.dom.Document
import org.w3c.dom.NodeList
import java.lang.Exception
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.parsers.DocumentBuilder

class MainActivity : AppCompatActivity() {
    val list: ArrayList<APIItem> = ArrayList()
    val array = arrayOf("1","2","3","4")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        parse()
        addApi()

        val adapter = RecyclerAdapter(list)
        recyclerView.adapter = adapter

        recyclerView.addItemDecoration(
            DividerItemDecoration(this,DividerItemDecoration.VERTICAL)
        )
    }

    fun addApi()
    {
        list.add(APIItem(array[0],getString(R.string.good),getString(R.string.bad),getString(R.string.verybad)))
        list.add(APIItem(array[1],getString(R.string.good),getString(R.string.bad),getString(R.string.verybad)))
        list.add(APIItem(array[2],getString(R.string.good),getString(R.string.bad),getString(R.string.verybad)))
        list.add(APIItem(array[3],getString(R.string.good),getString(R.string.bad),getString(R.string.verybad)))

    }

    private  fun parse()
    {
        Thread(Runnable {

            try {

                val key : String = "8OiqAUMXFw9L0mx%2FK%2F0GzYBNCV148qE9st68rDIuRSiuDHdCQs%2FBzo%2FeeyFeZFmduBdKP%2FxwEREP11pA7QabeQ%3D%3D"
                val option : String = "&numOfRows=10&pageNo=1&itemCode=PM25&dataGubun=HOUR&searchCondition=MONTH"
                //itemCode가 so2와 pm10,pm25 이렇게 세가지를 가지고 와서 하나씩 뿌려줘야함
                val url : String ="http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getCtprvnMesureLIst?serviceKey="+key+option
                val xml : Document = DocumentBuilderFactory.newInstance().newDocumentBuilder()
                    .parse(url)
                xml.documentElement.normalize()
                //노드 정규화
                val list1:NodeList=xml.getElementsByTagName("item")
                for(i in 0..xml.getElementsByTagName("item").item(0).childNodes.length-1)
                {

                    Log.e("에러1",xml.getElementsByTagName("item").item(0).childNodes.item(i).nodeType.toString())
                }
            }
            catch (e:Exception)
            {
                Log.e("에러",e.toString())

            }
        }).start()
    }

}
