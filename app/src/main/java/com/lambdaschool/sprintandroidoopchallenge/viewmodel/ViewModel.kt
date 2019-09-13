package com.lambdaschool.sprintandroidoopchallenge.viewmodel

import android.widget.Button
import com.lambdaschool.sprintandroidoopchallenge.model.*
import com.lambdaschool.sprintandroidoopchallenge.view.ItemDetailFragment
import java.util.HashMap

class ViewModel {

    val ITEMS: MutableList<AgeOfEmpires> = ArrayList()
    val ITEM_MAP: MutableMap<String, AgeOfEmpires> = HashMap()

    init {
        ITEMS.add(Civilizations("Aztecs", "The Conquerors",false, "Infantry and Monk", "Relics generate +33% gold"))
        ITEMS.add(Civilizations("Britons", "Age of Kings",false, "Foot Archer", "Archery Ranges work 20% faster"))
        ITEMS.add(Civilizations("Bizantines", "Age of Kings",false, "Defensive", "Monks +50% heal speed"))
        ITEMS.add(Civilizations("Celts", "Age of Kings",false, "Infantry","Siege Workshops work 20% faster"))
        ITEMS.add(Civilizations("Chinese", "Age of Kings",false, "Archer", "Famrs provide +45 food"))
        ITEMS.add(Civilizations("Franks", "Age of Kings",false, "Cavalry","Knights have +2 line of sight"))
        ITEMS.add(Civilizations("Goths", "Age of Kings", false,"Infantry","Barracks operate 20% faster"))
        ITEMS.add(Civilizations("Huns", "The Conquerors", false,"Cavalry","Stables are 20% faster"))
        ITEMS.add(Civilizations("Japanese", "Age of Kings", false,"Infantry","Galleys have +50% line of sight"))
        ITEMS.add(Civilizations("Koreans",  "The Conquerors",false, "Tower and naval","Mangonel line has +1 range"))

        ITEMS.add(Units("Archer","Age of Kings",false,"30", 4, "0/0","80%"))
        ITEMS.add(Units("Crossbowman","Age of Kings",false,"5",5, "0/0","85%"))
        ITEMS.add(Units("Arbalest","Age of Kings",false,"5",5, "6", "0/0"))
        ITEMS.add(Units("Cavalry Archer","Age of Kings",false,"4", 6, "0/0", "50%"))
        ITEMS.add(Units("Heavy Cavalry Archer","Age of Kings",false,"4", 7, "1/0", "50%"))
        ITEMS.add(Units("Hand Cannoneer","Age of Kings",false,"7",17, "1/0", "65%"))
        ITEMS.add(Units("Skirmisher","Age of Kings",false,"1-4", 2, "0/3", "90%"))
        ITEMS.add(Units("Elite Skirmisher","Age of Kings",false,"1-5", 3, "0/4", "90%"))
        ITEMS.add(Units("Eagle Warrior","The Conquerors",false,"None", 4, "0/2", "None"))
        ITEMS.add(Units("Eagle Warrior","The Conquerors",false,"None", 7, "0/2", "None"))

        ITEMS.add(Structures("Barracks","Age of Kings",false,50,1200,1200,"0/7"))
        ITEMS.add(Structures("Dock","Age of Kings",false,35,1800,1800,"0/7"))
        ITEMS.add(Structures("Farm","Age of Kings",false,15,480,0,"0/0"))
        ITEMS.add(Structures("Fish Trap","Age of Kings",false,53,50,1,"0/0"))
        ITEMS.add(Structures("House","Age of Kings",false,25,900,1,"0/7"))
        ITEMS.add(Structures("Lumber Camp","Age of Kings",false,35,35,5,"0/7"))
        ITEMS.add(Structures("Mill","Age of Kings",false,35,1000,5,"0/7"))
        ITEMS.add(Structures("Mining Camp","Mining Camp",false,35,1000,5,"0/7"))
        ITEMS.add(Structures("Town Center","Age of Kings",false,150,2400,7,"3/5"))
        ITEMS.add(Structures("Archery Range","Age of Kings",false,50,1500,5,"1/8"))

        ITEMS.add(Technologies("Crossbowman","Age of Kings",false,"Upgrade to Crossbowman","Castle",35))
        ITEMS.add(Technologies("Thumb Ring","Age of Kings",false,"Faster reload time (10-20%) and 100% accuracy","Castle",45))
        ITEMS.add(Technologies("Arbalest","Age of Kings",false,"Upgrade to Arbalest","Imperial",50))
        ITEMS.add(Technologies("Elite Skirmisher","Age of Kings",false,"Upgrade to Elite Skirmisher","Imperial",50))
        ITEMS.add(Technologies("Heavy Cavalry Archer","Age of Kings",false,"Upgrade to Cavalry Archer","Imperial",50))
        ITEMS.add(Technologies("Parthian Tactics","Age of Kings",false,"+1/+2 AR and Cavalry Archer +4 and Mangudai +2 agains pikeman","Imperial",65))
        ITEMS.add(Technologies("Man At Arms","Age of Kings",false,"Upgrade to Man at Arms","Feudal",40))
        ITEMS.add(Technologies("Tracking","Age of Kings",false,"+2 Line of Sight and +2 Search Radius","Feudal",35))
        ITEMS.add(Technologies("Long Swordman","Age of Kings",false,"Upgrade to Long Swordman","Castle",45))
        ITEMS.add(Technologies("Pikeman","Age of Kings",false,"Upgrade to Spearman","Castle",45))

        ITEM_MAP[ITEMS[0].name] = ITEMS[0]
        ITEM_MAP[ITEMS[1].name] = ITEMS[1]
        ITEM_MAP[ITEMS[2].name] = ITEMS[2]
        ITEM_MAP[ITEMS[3].name] = ITEMS[3]
        ITEM_MAP[ITEMS[4].name] = ITEMS[4]
        ITEM_MAP[ITEMS[5].name] = ITEMS[5]
        ITEM_MAP[ITEMS[6].name] = ITEMS[6]
        ITEM_MAP[ITEMS[7].name] = ITEMS[7]
        ITEM_MAP[ITEMS[8].name] = ITEMS[8]
        ITEM_MAP[ITEMS[9].name] = ITEMS[9]
        ITEM_MAP[ITEMS[10].name] = ITEMS[10]
        ITEM_MAP[ITEMS[11].name] = ITEMS[11]
        ITEM_MAP[ITEMS[12].name] = ITEMS[12]
        ITEM_MAP[ITEMS[13].name] = ITEMS[13]
        ITEM_MAP[ITEMS[14].name] = ITEMS[14]
        ITEM_MAP[ITEMS[15].name] = ITEMS[15]
        ITEM_MAP[ITEMS[16].name] = ITEMS[16]
        ITEM_MAP[ITEMS[17].name] = ITEMS[17]
        ITEM_MAP[ITEMS[18].name] = ITEMS[18]
        ITEM_MAP[ITEMS[19].name] = ITEMS[19]
        ITEM_MAP[ITEMS[20].name] = ITEMS[20]
        ITEM_MAP[ITEMS[21].name] = ITEMS[21]
        ITEM_MAP[ITEMS[22].name] = ITEMS[22]
        ITEM_MAP[ITEMS[23].name] = ITEMS[23]
        ITEM_MAP[ITEMS[24].name] = ITEMS[24]
        ITEM_MAP[ITEMS[25].name] = ITEMS[25]
        ITEM_MAP[ITEMS[26].name] = ITEMS[26]
        ITEM_MAP[ITEMS[27].name] = ITEMS[27]
        ITEM_MAP[ITEMS[28].name] = ITEMS[28]
        ITEM_MAP[ITEMS[29].name] = ITEMS[29]
        ITEM_MAP[ITEMS[30].name] = ITEMS[30]
        ITEM_MAP[ITEMS[31].name] = ITEMS[31]
        ITEM_MAP[ITEMS[32].name] = ITEMS[32]
        ITEM_MAP[ITEMS[33].name] = ITEMS[33]
        ITEM_MAP[ITEMS[34].name] = ITEMS[34]
        ITEM_MAP[ITEMS[35].name] = ITEMS[35]
        ITEM_MAP[ITEMS[36].name] = ITEMS[36]
        ITEM_MAP[ITEMS[37].name] = ITEMS[37]
        ITEM_MAP[ITEMS[38].name] = ITEMS[38]
        ITEM_MAP[ITEMS[39].name] = ITEMS[39]
    }

    fun clickListener(view: Button, item: AgeOfEmpires?, fragmentListener: ItemDetailFragment.FragmentListener?) {
        item?.let {
            fragmentListener?.showToast(it)
            if (item?.isFavorite == true) {
                item?.isFavorite = false
            } else {
                item?.isFavorite = true
            }
            view.text = item?.isFavorite.toString()
            fragmentListener?.showToast(it)
        }
    }
}
