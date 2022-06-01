package mk.domain;

public class Ranges {
    private Long min;
    private Long max;

    public Ranges(Long min, Long max) {
        this.min = min;
        this.max = max;
    }

    public Ranges() {
    }

    public Long getMin() {
        return min;
    }

    public void setMin(Long min) {
        this.min = min;
    }

    public Long getMax() {
        return max;
    }

    public void setMax(Long max) {
        this.max = max;
    }


}
