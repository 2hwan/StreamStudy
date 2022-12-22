package designPattern.builderPattern;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BuilderPattern {
    private int id;
    private String name;
    private String emailAddress;
    private boolean isVerified;
    private LocalDateTime createdAt;
    private List<Integer> friendUserIds = new ArrayList<>();

    public BuilderPattern (Builder builder){ //constructor 생성자, build() 호출시 해당 객체 instance 가 만들어짐
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

    public static class Builder {
        private int id;
        private String name;
        private String emailAddress;
        private boolean isVerified;
        private LocalDateTime createdAt;
        private List<Integer> friendUserIds;

        private Builder(int id, String name){ // 처음 생성될 때 필수로 지정됨 private 임
            this.id = id;
            this.name = name;
        }

        public Builder withEmailAddress(String emailAddress){ // 추후에 필요료할 때 할당할 수 있는 public기능
            this.emailAddress = emailAddress;
            return this;
        }

        public Builder withVerified(boolean isVerified){
            this.isVerified = isVerified;
            return this;
        }

        public Builder withCreatedAt(LocalDateTime createdAt){
            this.createdAt = createdAt;
            return this;
        }

        public Builder withFriendUserIds(List<Integer> friendUserIds){
            this.friendUserIds = friendUserIds;
            return this;
        }

        public BuilderPattern build(){ // build() 호출시 constructor 가 호출됨.
            return new BuilderPattern(this);
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
