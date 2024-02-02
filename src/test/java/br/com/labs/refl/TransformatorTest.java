package br.com.labs.refl;

import br.com.labs.Endereco;
import br.com.labs.Pessoa;
import br.com.labs.PessoaDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

class TransformatorTest {

    Pessoa pessoa = new Pessoa(1, "Fulano", "12234");
    Endereco endereco = new Endereco("rua 1", 5);

    @Test
    void shouldTransform() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        Transformator transformator = new Transformator();

        PessoaDTO pessoaDTO = transformator.transform(pessoa);

        Assertions.assertInstanceOf(PessoaDTO.class, pessoaDTO);
        Assertions.assertEquals(pessoaDTO.getCpf(), pessoa.getCpf());

    }

    @Test
    void shouldNotTransform() {
        Transformator transformator = new Transformator();

        Assertions.assertThrows(ClassNotFoundException.class, () -> {
            transformator.transform(endereco);
        });

    }

    @Test
    void shouldTransformWhenSomeFieldIsNull() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        Pessoa pessoa = new Pessoa("giovanne");
        Transformator transformator = new Transformator();
        PessoaDTO pessoaDTO = transformator.transform(pessoa);

        Assertions.assertEquals(pessoaDTO.getNome(), pessoa.getNome());
    }
}