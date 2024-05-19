package fragments.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.multiapp.R

class ContactoAdapter(private var lstcontacto: List<ContactosModel>):RecyclerView.Adapter<ContactoAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val imgContacto: ImageView = itemView.findViewById(R.id.imgContacto)
        val etNombre: TextView = itemView.findViewById(R.id.lblNombre)
        val etTelefono: TextView = itemView.findViewById(R.id.lblNumeroTelefono)
        val etFecha: TextView = itemView.findViewById(R.id.lblFecha)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_contacto,parent,false))
    }

    override fun getItemCount(): Int {
       return lstcontacto.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemContacto = lstcontacto[position]
        holder.etNombre.text = itemContacto.nombre
        holder.etTelefono.text = itemContacto.numero
        holder.etFecha.text = itemContacto.fecha
    }
}