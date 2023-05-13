package fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.Intents
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uts_botnavrecview.*


class CharacterFrag : Fragment() {
    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private lateinit var adapter: CharactersAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var charArrayList: ArrayList<Characters>

    lateinit var image: Array<Int>
    lateinit var title: Array<String>
    lateinit var description: Array<String>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_character, container, false)
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rvChar)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = CharactersAdapter(charArrayList){
        val intent = Intent(context,DetailCharacterActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE,it)
            startActivity(intent)
        }

    }

    private fun dataInitialize() {
        charArrayList = arrayListOf<Characters>()

        image = arrayOf(
            R.drawable.ceraluronikessentoner,
            R.drawable.ceratinolmoisturizer,
            R.drawable.eyecream,
            R.drawable.facialcleanser,
            R.drawable.moisturizer,
            R.drawable.peelinggelclaymask,
            R.drawable.peelingsolution,
            R.drawable.retinolb3serum,
            R.drawable.roseb3brighteningjellymask,
            R.drawable.serum,
        )

        title = arrayOf(
            getString(R.string.ceraluronikessentoner),
            getString(R.string.ceratinolmoisturizer),
            getString(R.string.eyecream),
            getString(R.string.facialcleanser),
            getString(R.string.moisturizer),
            getString(R.string.peelinggelclaymask),
            getString(R.string.peelingsolution),
            getString(R.string.retinolb3serum),
            getString(R.string.roseb3brighteningjellymask),
            getString(R.string.serum),

        )
        description = arrayOf(
            getString(R.string.desc_ceraluronikessentoner),
            getString(R.string.desc_ceratinolmoisturizer),
            getString(R.string.desc_eyecream),
            getString(R.string.desc_facialcleanser),
            getString(R.string.desc_moisturizer),
            getString(R.string.desc_peelinggelclaymask),
            getString(R.string.desc_peelingsolution),
            getString(R.string.desc_retinolb3serum),
            getString(R.string.desc_roseb3brighteningjellymask),
            getString(R.string.desc_serum),
        )

        for (i in image.indices) {
            val char = Characters(image[i], title[i], description[i])
            charArrayList.add(char)
        }

    }
}
