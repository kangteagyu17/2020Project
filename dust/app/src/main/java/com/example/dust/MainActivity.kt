package com.example.dust

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.*
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
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
        //각 배열에 저장된 값을 리스트에 추가해서 리사이클러뷰로 만들어줘야함
        list.add(APIItem(array[0],getString(R.string.good),getString(R.string.bad),getString(R.string.verybad)))
        list.add(APIItem(array[1],getString(R.string.good),getString(R.string.bad),getString(R.string.verybad)))
        list.add(APIItem(array[2],getString(R.string.good),getString(R.string.bad),getString(R.string.verybad)))
        list.add(APIItem(array[3],getString(R.string.good),getString(R.string.bad),getString(R.string.verybad)))

    }

    private  fun parse()
    {
        Thread(Runnable {
            //pm25(초 미세먼지)
            try {

                val key : String = "8OiqAUMXFw9L0mx%2FK%2F0GzYBNCV148qE9st68rDIuRSiuDHdCQs%2FBzo%2FeeyFeZFmduBdKP%2FxwEREP11pA7QabeQ%3D%3D"
                val option25 : String = "&numOfRows=10&pageNo=1&itemCode=PM25&dataGubun=HOUR&searchCondition=MONTH"
                val optionSo2 : String = "&numOfRows=10&pageNo=1&itemCode=SO2&dataGubun=HOUR&searchCondition=MONTH"
                val option10 : String = "&numOfRows=10&pageNo=1&itemCode=PM10&dataGubun=HOUR&searchCondition=MONTH"
                //itemCode가 so2와 pm10,pm25 이렇게 세가지를 가지고 와서 하나씩 뿌려줘야함
                val url10 : String ="http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getCtprvnMesureLIst?serviceKey="+key+option10
                val url25 : String ="http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getCtprvnMesureLIst?serviceKey="+key+option25
                val urlSo2 : String ="http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getCtprvnMesureLIst?serviceKey="+key+optionSo2
                val xml10 : Document = DocumentBuilderFactory.newInstance().newDocumentBuilder()
                    .parse(url10)
                xml10.documentElement.normalize()

                val xml25 : Document = DocumentBuilderFactory.newInstance().newDocumentBuilder()
                    .parse(url25)
                xml25.documentElement.normalize()

                val xmlSo2 : Document = DocumentBuilderFactory.newInstance().newDocumentBuilder()
                    .parse(urlSo2)
                xmlSo2.documentElement.normalize()

                //노드 정규화
                val list1:NodeList=xml10.getElementsByTagName("item")

                   // var node: Node =list1.item(i)
                 //   val elem = node as Element
             //   Log.e("에러 자식노드 개수 : ",xml10.getElementsByTagName("item").item(0).childNodes.item(0).nodeName)
             //   Log.e("에러수",xml10.getElementsByTagName("item").item(0).childNodes.length.toString())
             //   Log.e("에러 맨 나중수",xml10.getElementsByTagName("item").length.toString())

                    if(xml10.getElementsByTagName("item").item(0).nodeType == Node.ELEMENT_NODE) {
                      //  Log.e("에러1", xml10.getElementsByTagName("item").item(0).textContent)//전체 값 가져오기
                        //api를 받아오는데 \n이나 공백을 그대로 가져옴 그래서 가공이 필요함
                        //받아와서
                        val st : String = xml25.getElementsByTagName("item").item(0).textContent.toString()
                        //줄바꿈 기호를 기준으로 배열로 나눔
                        val arr = st.split("\n")
                        for(i in 10..arr.lastIndex-1) {
                            //출력하면서 앞에 있는 공백을 모두 제거(문제점 배열에 비해서 들어간 데이터가 적음) 0~9번째 배열은 필요 없으므로 삭제할 필요가 있음
                            Log.e("에러1", arr[i].trim()+ " " + i.toString())//전체 값 가져오기
                           // Log.e("에러1", st.toString())
                        }


                        //busan,daegu,incheon,gwangju,daejeon,ulsan,gyeonggi,gangwon,chungbuk,chungnam,jeonbuk,jeonnam,gyeongbuk,gyeongnam,jeju,sejong
                        //값을 가져와 다른 클래스에 저장 할 수 있어야 함
                    }


            }
            catch (e:Exception)
            {
                Log.e("에러",e.toString())

            }



        }).start()
    }

}
