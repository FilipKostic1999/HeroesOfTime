package com.example.heroesoftime


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView




class itemShopViewAdapter(private val armorList: ArrayList<armorClass>) :
    RecyclerView.Adapter<itemShopViewAdapter.ArmorViewHolder>() {

    private var onBuyClickListener: OnBuyClickListener? = null

    interface OnBuyClickListener {
        fun onBuyClick(armor: armorClass)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArmorViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_armor_shop_item, parent, false)
        return ArmorViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArmorViewHolder, position: Int) {
        val armor = armorList[position]
        holder.bind(armor)
    }

    override fun getItemCount(): Int {
        return armorList.size
    }

    fun setOnBuyClickListener(listener: OnBuyClickListener) {
        onBuyClickListener = listener
    }

    inner class ArmorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameImageViewArmor: ImageView = itemView.findViewById(R.id.armorDefaultImg)
        private val armorData: TextView = itemView.findViewById(R.id.armorDataTxt)
        private val buyBtn: Button = itemView.findViewById(R.id.buyBtn)

        fun bind(armor: armorClass) {
            armorData.text = "${armor.armorName}, armor: ${armor.armor}, vitality: ${armor.vitality}," +
                    " strength: ${armor.strenght}, speed: ${armor.speed}, mana: ${armor.mana}," +
                    " price: ${armor.price} gold"

            when (armor.itemId) {
                in 1..4 -> nameImageViewArmor.setImageResource(R.drawable.leatherarmor)
                in 5..6 -> nameImageViewArmor.setImageResource(R.drawable.rareleatherarmor)
                in 7..10 -> nameImageViewArmor.setImageResource(R.drawable.leatherrobe)
                in 11..12 -> nameImageViewArmor.setImageResource(R.drawable.rareleatherrobe)
                in 13..16 -> nameImageViewArmor.setImageResource(R.drawable.leathergloves)
                in 17..18 -> nameImageViewArmor.setImageResource(R.drawable.rareleathergloves)
                in 19..22 -> nameImageViewArmor.setImageResource(R.drawable.leathershoes)
                in 23..24 -> nameImageViewArmor.setImageResource(R.drawable.rareleathershoes)
                in 25..28 -> nameImageViewArmor.setImageResource(R.drawable.leathershield)
                in 29..30 -> nameImageViewArmor.setImageResource(R.drawable.rareleathershield)
                in 31..34 -> nameImageViewArmor.setImageResource(R.drawable.leatherbelt)
                in 35..36 -> nameImageViewArmor.setImageResource(R.drawable.rareleatherbelt)
                in 37..40 -> nameImageViewArmor.setImageResource(R.drawable.leatherhat)
                in 41..42 -> nameImageViewArmor.setImageResource(R.drawable.rareleatherhat)
                in 43..45 -> nameImageViewArmor.setImageResource(R.drawable.knife)
                in 46..47 -> nameImageViewArmor.setImageResource(R.drawable.bow)
                48 -> nameImageViewArmor.setImageResource(R.drawable.rareknife)
                49 -> nameImageViewArmor.setImageResource(R.drawable.strongbow)
                50 -> nameImageViewArmor.setImageResource(R.drawable.strongwarknife)
                51 -> nameImageViewArmor.setImageResource(R.drawable.sword)
                in 52..54 -> nameImageViewArmor.setImageResource(R.drawable.throwingknives)
                in 55..56 -> nameImageViewArmor.setImageResource(R.drawable.warknife)
                in 57..59 -> nameImageViewArmor.setImageResource(R.drawable.pinkring)
                in 60..61 -> nameImageViewArmor.setImageResource(R.drawable.rarepinkring)
                in 62..64 -> nameImageViewArmor.setImageResource(R.drawable.amulet)
                in 65..66 -> nameImageViewArmor.setImageResource(R.drawable.rareamulet)
                else -> {
                    // Handle the case when the itemId doesn't match any of the above conditions
                }
            }

            buyBtn.setOnClickListener {
                onBuyClickListener?.onBuyClick(armor)
            }
        }


    }
}


