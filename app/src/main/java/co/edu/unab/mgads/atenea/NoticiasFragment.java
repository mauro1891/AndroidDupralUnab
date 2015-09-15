package co.edu.unab.mgads.atenea;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import co.edu.unab.mgads.atenea.RecyclerView.Adapters.PostNoticiasAdapter;
import co.edu.unab.mgads.atenea.entity.PostNoticiaResponse;


/**
 * A simple {@link Fragment} subclass.
 */
public class NoticiasFragment extends Fragment {
    // Atributos
    ListView listView;
    ArrayAdapter adapter;
    TextView mEdit;
    private PostNoticiaResponse PostNoticiaResponse;
    public NoticiasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_noticias, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // Obtener instancia de la lista
        listView = (ListView) getActivity().findViewById(R.id.listNoticias);

        // Crear adaptador y setear
        adapter = new PostNoticiasAdapter(getActivity());
        listView.setAdapter(adapter);


        // Regisgrar escucha de la lista
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cursor ca = (Cursor) adapter.getItem(position);

                // Obtene Titulo de la entrada seleccionada
                String Titulo = ca.getString(ca.getColumnIndex(co.edu.unab.mgads.atenea.entity.PostNoticiaResponse.titulo));

                // Nuevo intent expl�cito
                Intent i = new Intent(getActivity(), Fragment2.class);

                // Setear url
                i.putExtra("Titulo", Titulo);

                // Iniciar actividad
                startActivity(i);
            }
        });

    }
}
