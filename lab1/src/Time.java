/**
 * Класс для представления времени с валидацией
 * Ошибки в оригинале: minutes проверялось до 60 вместо 59
 */
public class Time {
    private int hours;
    private int minutes;

    public Time(int hours, int minutes) {
        setHours(hours);
        setMinutes(minutes);
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setHours(int hours) {
        if (hours < 0 || hours > 23) {
            throw new IllegalArgumentException("Часы должны быть от 0 до 23");
        }
        this.hours = hours;
    }

    public void setMinutes(int minutes) {
        if (minutes < 0 || minutes > 59) { // ИСПРАВЛЕНО: было 60, должно быть 59
            throw new IllegalArgumentException("Минуты должны быть от 0 до 59");
        }
        this.minutes = minutes;
    }

    /**
     * Получить время в минутах от начала дня (для сравнения)
     */
    public int toMinutes() {
        return hours * 60 + minutes;
    }

    /**
     * Сравнить время с другим объектом Time
     */
    public boolean isAfter(Time other) {
        return this.toMinutes() > other.toMinutes();
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d", hours, minutes);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Time time = (Time) obj;
        return hours == time.hours && minutes == time.minutes;
    }

    @Override
    public int hashCode() {
        return 31 * hours + minutes;
    }
}