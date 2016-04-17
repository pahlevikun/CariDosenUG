package com.ctproject.caridosenug.Models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by farhan on 2/29/16.
 */

public class Model {

    private List<Listdosen> listdosen = new ArrayList<Listdosen>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<Listdosen> getListdosen() {
        return listdosen;
    }

    public void setListdosen(List<Listdosen> listdosen) {
        this.listdosen = listdosen;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}