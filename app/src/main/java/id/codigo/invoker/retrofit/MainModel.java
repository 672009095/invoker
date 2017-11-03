package id.codigo.invoker.retrofit;

import android.databinding.ObservableField;
import android.databinding.ViewDataBinding;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * Created by papahnakal on 25/10/17.
 */

public class MainModel{
    @SerializedName("status")
    private String status;
    @SerializedName("message")
    private String message;
    @SerializedName("display_message")
    private String display_message;
    @JsonAdapter(DataAdapterFactory.class)
    private Data data;

    private ObservableField<String> username = new ObservableField<>("");
    private ObservableField<String> password = new ObservableField<>("");

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDisplay_message() {
        return display_message;
    }

    public void setDisplay_message(String display_message) {
        this.display_message = display_message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public ObservableField<String> getUsername() {
        return username;
    }

    public void setUsername(ObservableField<String> username) {
        this.username = username;
    }

    public ObservableField<String> getPassword() {
        return password;
    }

    public void setPassword(ObservableField<String> password) {
        this.password = password;
    }

    public static class Data {
        @SerializedName("id_user")
        private String id_user;

        public String getId_user() {
            return id_user;
        }

        public void setId_user(String id_user) {
            this.id_user = id_user;
        }
    }

    public static class DataAdapterFactory implements TypeAdapterFactory {
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            return (TypeAdapter<T>) new DataAdapter(gson);
        }
    }

    public static class DataAdapter extends TypeAdapter<Data> {
        private final Gson gson;

        public DataAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override
        public void write(JsonWriter out, Data value) throws IOException {
            throw new RuntimeException("Not implemented");
        }

        @Override
        public Data read(JsonReader in) throws IOException {
            switch (in.peek()) {
                case BEGIN_OBJECT:
                    return gson.fromJson(in, Data.class);
                default:
                    in.skipValue();
                    return new Data();
            }
        }
    }
}
