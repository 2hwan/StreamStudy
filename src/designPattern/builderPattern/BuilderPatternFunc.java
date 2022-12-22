package designPattern.builderPattern;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class BuilderPatternFunc {
    private int id;
    private String name;
    private String emailAddress;
    private boolean isVerified;
    private LocalDateTime createdAt;
    private List<Integer> friendUserIds = new ArrayList<>();

    public BuilderPatternFunc(Builder builder){ //constructor 생성자, build() 호출시 해당 객체 instance 가 만들어짐
        this.id = builder.id;
        this.name = builder.name;
        this.emailAddress = builder.emailAddress;
        this.isVerified = builder.isVerified;
        this.createdAt = builder.createdAt;
        this.friendUserIds = builder.friendUserIds;
    }

    public static Builder builder(int id, String name){
        return new Builder(id, name);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Optional<String> getEmailAddress() {
        return Optional.ofNullable(emailAddress);
    }

    public boolean isVerified() {
        return isVerified;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public List<Integer> getFriendUserIds() {
        return friendUserIds;
    }

    public static class Builder {
        private int id;
        private String name;
        public String emailAddress;
        public boolean isVerified;
        public LocalDateTime createdAt;
        public List<Integer> friendUserIds;

        private Builder(int id, String name){ // 처음 생성될 때 필수로 지정됨 private 임
            this.id = id;
            this.name = name;
        }

        public Builder with(Consumer<Builder> consumer){ // 기존 일일이 set 하던걸 consumer 로 해결
            consumer.accept(this);
            return this;
        }

        public BuilderPatternFunc build(){ // build() 호출시 constructor 가 호출됨.
            return new BuilderPatternFunc(this);
        }
    }

    @Override
    public String toString() {
        return "BuilderPattern{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", isVerified=" + isVerified +
                ", createdAt=" + createdAt +
                ", friendUserIds=" + friendUserIds +
                '}';
    }
}
