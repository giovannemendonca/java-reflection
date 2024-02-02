package br.com.labs.refl;

import br.com.labs.Pessoa;

class ObjectToJsonTester {

    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa(1,"João","1510");
        ObjectToJson objectToJson = new ObjectToJson();
        String json = objectToJson.transform(pessoa);
        System.out.println(json);
    }
}