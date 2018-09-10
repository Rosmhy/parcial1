package manuel.com.co.proyecto.dominio;

import java.util.List;

import manuel.com.co.listas.R;
import manuel.com.co.proyecto.datasource.CampingRemoteDataSource;
import manuel.com.co.proyecto.modelo.Camping;
import manuel.com.co.proyecto.modelo.CampingS;

public class CampingDominio {

    private View view;
    private CampingRemoteDataSource campingRemoteDataSource;

    public CampingDominio(View view, CampingRemoteDataSource campingRemoteDataSource) {
        this.view = view;
        this.campingRemoteDataSource = campingRemoteDataSource;
    }

    public void consultarCampings() {
        campingRemoteDataSource.consultarCamping(new CampingRemoteDataSource.GetCampingCallback() {
            @Override
            public void onCampingLoaded(List<Camping> camping) {
                view.showCampings(camping);
            }

            @Override
            public void onError() {
                view.showMensaje(R.string.error_generico);
            }
        });
    }

    public void guardarCampings(CampingS camping) {
        campingRemoteDataSource.guardarCamping(new CampingRemoteDataSource.PostCampingCallback() {
            @Override
            public void guardarCamping() {
                view.showMensaje(R.string.mensaje_generico_guardar);
            }

            @Override
            public void onError() {
                view.showMensaje(R.string.error_generico);
            }
        }, camping);
    }

    public interface View {
        void showCampings(List<Camping> campings);

        void showMensaje(int mensaje);
    }
}
