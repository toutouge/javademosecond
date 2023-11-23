package com.example.demo.util;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import lombok.SneakyThrows;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @Author chen bo
 * @Date 2024/4
 * @Des
 */
public class GsonUtils {

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    private static final JsonSerializer<LocalDateTime> dateTimeSerializer
            = (obj, type, ctx) -> new JsonPrimitive(dateTimeFormatter.format(obj));
    private static final JsonSerializer<LocalDate> dateSerializer
            = (obj, type, ctx) -> new JsonPrimitive(dateFormatter.format(obj));
    private static final JsonSerializer<LocalTime> timeSerializer
            = (obj, type, ctx) -> new JsonPrimitive(timeFormatter.format(obj));

    private static final JsonDeserializer<LocalDateTime> dateTimeDeserializer
            = (json, type, ctx) -> LocalDateTime.parse(json.getAsJsonPrimitive().getAsString(), dateTimeFormatter);
    private static final JsonDeserializer<LocalDate> dateDeserializer
            = (json, type, ctx) -> LocalDate.parse(json.getAsJsonPrimitive().getAsString(), dateFormatter);
    private static final JsonDeserializer<LocalTime> timeDeserializer
            = (json, type, ctx) -> LocalTime.parse(json.getAsJsonPrimitive().getAsString(), timeFormatter);

    private static final Gson gson;

    static {
        GsonBuilder builder = new GsonBuilder();
        builder.disableHtmlEscaping();
        builder.enableComplexMapKeySerialization();
        // builder.excludeFieldsWithoutExposeAnnotation();
        builder.setDateFormat("yyyy-MM-dd HH:mm:ss");
        builder.registerTypeAdapter(LocalDateTime.class, dateTimeSerializer);
        builder.registerTypeAdapter(LocalDate.class, dateSerializer);
        builder.registerTypeAdapter(LocalTime.class, timeSerializer);
        builder.registerTypeAdapter(LocalDateTime.class, dateTimeDeserializer);
        builder.registerTypeAdapter(LocalDate.class, dateDeserializer);
        builder.registerTypeAdapter(LocalTime.class, timeDeserializer);
        gson = builder.create();
    }

    public static Type makeJavaType(Type rawType, Type... typeArguments) {
        return TypeToken.getParameterized(rawType, typeArguments).getType();
    }

    public static String toString(Object value) {
        if (Objects.isNull(value)) {
            return null;
        }
        if (value instanceof String) {
            return (String) value;
        }
        return toJSONString(value);
    }

    public static String toJSONString(Object value) {
        return gson.toJson(value);
    }

    public static String toPrettyString(Object value) {
        return gson.newBuilder().setPrettyPrinting().create().toJson(value);
    }

    public static JsonElement fromJavaObject(Object value) {
        JsonElement result = null;
        if (Objects.nonNull(value) && (value instanceof String)) {
            result = parseObject((String) value);
        } else {
            result = gson.toJsonTree(value);
        }
        return result;
    }

    @SneakyThrows
    public static JsonElement parseObject(String content) {
        return JsonParser.parseString(content);
    }

    public static JsonElement getJsonElement(JsonObject node, String name) {
        return node.get(name);
    }

    public static JsonElement getJsonElement(JsonArray node, int index) {
        return node.get(index);
    }

    @SneakyThrows
    public static <T> T toJavaObject(JsonElement node, Class<T> clazz) {
        return gson.fromJson(node, clazz);
    }

    @SneakyThrows
    public static <T> T toJavaObject(JsonElement node, Type type) {
        return gson.fromJson(node, type);
    }

    public static <T> T toJavaObject(JsonElement node, TypeToken<?> typeToken) {
        return toJavaObject(node, typeToken.getType());
    }

    public static <E> List<E> toJavaList(JsonElement node, Class<E> clazz) {
        return toJavaObject(node, makeJavaType(List.class, clazz));
    }

    public static List<Object> toJavaList(JsonElement node) {
        return toJavaObject(node, new TypeToken<List<Object>>() {
        }.getType());
    }

    public static <V> Map<String, V> toJavaMap(JsonElement node, Class<V> clazz) {
        return toJavaObject(node, makeJavaType(Map.class, String.class, clazz));
    }

    public static Map<String, Object> toJavaMap(JsonElement node) {
        return toJavaObject(node, new TypeToken<Map<String, Object>>() {
        }.getType());
    }

    @SneakyThrows
    public static <T> T toJavaObject(String content, Class<T> clazz) {
        return gson.fromJson(content, clazz);
    }

    @SneakyThrows
    public static <T> T toJavaObject(String content, Type type) {
        return gson.fromJson(content, type);
    }

    public static <T> T toJavaObject(String content, TypeToken<?> typeToken) {
        return toJavaObject(content, typeToken.getType());
    }

    public static <E> List<E> toJavaList(String content, Class<E> clazz) {
        return toJavaObject(content, makeJavaType(List.class, clazz));
    }

    public static List<Object> toJavaList(String content) {
        return toJavaObject(content, new TypeToken<List<Object>>() {
        }.getType());
    }

    public static <V> Map<String, V> toJavaMap(String content, Class<V> clazz) {
        return toJavaObject(content, makeJavaType(Map.class, String.class, clazz));
    }

    public static Map<String, Object> toJavaMap(String content) {
        return toJavaObject(content, new TypeToken<Map<String, Object>>() {
        }.getType());
    }

}
