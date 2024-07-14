package com.kbnproject.literalura.service;

public interface IDataCast {
    <T> T toObject(String json, Class<T> tClass);
}
