# Collections

# Stack

# Map

| Type             | Method                                     | Description                                                                                                                                                             |
| ---------------- | ------------------------------------------ | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `V`              | `put(K key, V value)`                      | Associates the specified value with the specified key in this map (optional operation).                                                                                 |
| `V`              | `putIfAbsent(K key, V value)`              | If the specified key is not already associated with a value (or is mapped to null) associates it with the given value and returns null, else returns the current value. |
| `void`           | `putAll(Map<? extends K, ? extends V> m)`  | Copies all of the mappings from the specified map to this map (optional operation).                                                                                     |
| `boolean`        | `containsKey(Object key)`                  | Returns `true` if this map contains a mapping for the specified key.                                                                                                    |
| `boolean`        | `containsValue(Object value)`              | Returns `true` if this map maps one or more keys to the specified value.                                                                                                |
| `V`              | `get(Object key)`                          | Returns the value to which the specified key is mapped, or `null` if this map contains no mapping for the key.                                                          |
| `V`              | `getOrDefault(Object key, V defaultValue)` | Returns the value to which the specified key is mapped, or `defaultValue` if this map contains no mapping for the key.                                                  |
| `Map.Entry<K,V>` | `entrySet()`                               | Returns a Set view of the mappings contained in this map.                                                                                                               |

`merge(K key, V value, BiFunction<? super V, ? super V, extends V> remappingFunction)`

`V computeIfAbsent(K key, Function<K, V> mappingFunction)`

| Operation | HashMap           | TreeMap      | LinkedHashMap |
| --------- | ----------------- | ------------ | ------------- |
| Insertion | $O(1)/O(\log{n})$ | $O(\log{n})$ | $O(1)/O(n)$   |
| Deletion  | $O(1)/O(\log{n})$ | $O(\log{n})$ | $O(1)/O(n)$   |
| Search    | $O(1)/O(\log{n})$ | $O(\log{n})$ | $O(1)/O(n)$   |



## Queue

### PriorityQueue

- `PriorityQueue()`
- `PriorityQueue(int initialCapacity)`
- `PriorityQueue(Comparator comparator)`
