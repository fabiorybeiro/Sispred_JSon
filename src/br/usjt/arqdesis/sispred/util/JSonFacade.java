package br.usjt.arqdesis.sispred.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import br.usjt.arqdesis.sispred.model.Usuario;

public class JSonFacade {
	public static StringBuilder montaJSon(HttpServletRequest request)
			throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = request.getReader();
		try {
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line).append('\n');
			}
		} finally {
			reader.close();
		}
		return sb;
	}

	public static String listToJSon(ArrayList<Usuario> lista) {
		JSONArray vetor = new JSONArray();
		for (Usuario to : lista) {
			JSONObject object = new JSONObject();
			try {
				object.put("id", to.getId());
				object.put("nome", to.getNome());
				object.put("sobrenome", to.getSobrenome());
				object.put("cpf", to.getCpf());
				object.put("username", to.getUsername());
				vetor.put(object);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return vetor.toString();
	}

	public static Usuario jSonToUsuario(String json) throws IOException{
		try{
			JSONObject registro = new JSONObject(json);
			int id = registro.getInt("id");
			String nome = registro.getString("nome");
			String sobrenome = registro.getString("sobrenome");
			String cpf = registro.getString("cpf");
			String username = registro.getString("username");
			Usuario user = new Usuario();
			user.setId(id);
			user.setNome(nome);
			user.setSobrenome(sobrenome);
			user.setCpf(cpf);
			user.setUsername(username);
			return user;
		} catch(JSONException jsone){
			jsone.printStackTrace();
			throw new IOException(jsone);
		}
	}
	
	public static String usuarioToJSon(Usuario user) throws IOException {
		JSONObject object = new JSONObject();
		try {
			object.put("id", user.getId());
			object.put("nome", user.getNome());
			object.put("sobrenome", user.getSobrenome());
			object.put("cpf", user.getCpf());
			object.put("username", user.getUsername());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return object.toString();
	}

	public static String errorToJSon(Exception e) {
		JSONObject object = new JSONObject();
		try {
			object.put("error", e.toString());
		} catch (JSONException e1) {
			e.printStackTrace();
		}
		return object.toString();
	}
}
