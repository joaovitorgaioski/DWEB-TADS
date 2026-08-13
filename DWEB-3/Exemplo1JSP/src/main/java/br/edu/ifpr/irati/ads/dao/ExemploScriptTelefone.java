package br.edu.ifpr.irati.ads.dao;

import org.hibernate.Session;

import java.util.List;

public class ExemploScriptTelefone {

    public static void main(String[] args) {

        Dao<Telefone> telefoneDAO = new GenericDao<>(Telefone.class);

        Telefone t1 = new Telefone(0L, "4299999-8888");
        telefoneDAO.salvar(t1);

        Telefone t2 = new Telefone(0L, "4297777-6666");
        telefoneDAO.salvar(t2);

        /*Lazy objects não são totalmente carregados
        e objetos de relacionamento não seriam carregados
        se a sessão fosse fechada dentro do método
        buscarTodos. Por isso, é necessário fornecer a sessão e de
        depois fechá-la.*/
        Session new_session = HibernateUtil.getSessionFactory().openSession();
        List<Telefone> telefones = telefoneDAO.buscarTodos(new_session);
        System.out.println(telefones);
        new_session.close();



    }

}
