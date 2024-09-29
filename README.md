Тут простіше сказати, яким чином код було перероблено. Замість зберігання даних у змінних, використанні масив і так далі, я використав підхід зі словниками, stream і лістами. Було всюди виставлено правильно пробіли, табуляції. Код доповнено коментарями, щоб було легше зрозуміти, що там відбувається. Через цей рефакторінг, було також виявлено, що початковий код неправильно справлявся із завданням, адже багато слів було втрачено при пошуку тих слів. Наприклад, слово the, котре є найбільш використовуваним, не знаходилось старим алгоритмом і багато інших в ході перевірки. Також провів перевірку за допомогою вбудованого пошуку Intellij, щоб вияснити котрий код правильніше шукає. Поміняв url на filepath, бо це більш чітко відображає суть змінної і в цілому дані зміни, а саме використання stream і словників і певна оптимізація обробки самого тексту допомогла не тільки збільшити точність алгоритму, а ще й суттєво зменшила час виконання алгоритма. У моєму випадку початковий алгоритм виконувався ~3000 мс, а оновлений 260-290 мс.
