package com.aluracursos.screenmatch.service;

public interface IDataConversion {
    <T>T obtainData(String url, Class<T> tClass);
}
