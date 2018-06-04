//package zhj.viewpagerdemo.serialize;
//
//import android.os.Parcel;
//import android.os.Parcelable;
//
///**
// * 作者：shiyuzhe on 2018/4/20 20:17
// * <p>
// * 邮箱：18091664559@163.com
// */
//public class bean2 implements Parcelable {
//    private String id;
//    private String name;
//    private String age;
//
//    public bean2(String id, String name, String age) {
//        this.id = id;
//        this.name = name;
//        this.age = age;
//    }
//
//    public String getId() {
//        return id == null ? "" : id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name == null ? "" : name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getAge() {
//        return age == null ? "" : age;
//    }
//
//    public void setAge(String age) {
//        this.age = age;
//    }
//
//    public Book book;
//
//    public static final Parcelable.Creator<bean2> CREATOR = new Parcelable.Creator<bean2>() {
//
//        @Override
//        public bean2 createFromParcel(Parcel source) {
//            return new bean2(source);
//        }
//
//        @Override
//        public bean2[] newArray(int size) {
//            return new bean2[size];
//        }
//
//
//    };
//
//    private bean2(Parcel source) {
//        source.readString();
//
//    }
//
//    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//    @Override
//    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeString(getId());
//        dest.writeString(getName());
//        dest.writeString(getAge());
//        dest.writeParcelable(book,0);
//
//    }
//}
