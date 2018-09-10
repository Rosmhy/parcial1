package manuel.com.co.proyecto.datasource;

import java.util.List;

import manuel.com.co.proyecto.modelo.Camping;
import manuel.com.co.proyecto.modelo.CampingS;

public interface CampingRemoteDataSource {

    void consultarCamping(GetCampingCallback callback);
    void guardarCamping(PostCampingCallback callback, CampingS camping);

    public interface GetCampingCallback{
        void onCampingLoaded(List<Camping> camping);
        void onError();
    }

    public interface PostCampingCallback{
        void guardarCamping();
        void onError();
    }
}
