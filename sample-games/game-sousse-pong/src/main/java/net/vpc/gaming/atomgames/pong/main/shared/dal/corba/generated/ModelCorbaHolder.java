package net.vpc.gaming.atomgames.pong.main.shared.dal.corba.generated;

/**
 * tn/edu/eniso/pong/main/shared/dal/corba/generated/ModelCorbaHolder.java .
 * Generated by the IDL-to-Java compiler (portable), version "3.2"
 * from DalCorba.idl
 * Tuesday, December 20, 2011 11:10:02 PM CET
 */

public final class ModelCorbaHolder implements org.omg.CORBA.portable.Streamable {
    public net.vpc.gaming.atomgames.pong.main.shared.dal.corba.generated.ModelCorba value = null;

    public ModelCorbaHolder() {
    }

    public ModelCorbaHolder(net.vpc.gaming.atomgames.pong.main.shared.dal.corba.generated.ModelCorba initialValue) {
        value = initialValue;
    }

    public void _read(org.omg.CORBA.portable.InputStream i) {
        value = net.vpc.gaming.atomgames.pong.main.shared.dal.corba.generated.ModelCorbaHelper.read(i);
    }

    public void _write(org.omg.CORBA.portable.OutputStream o) {
        net.vpc.gaming.atomgames.pong.main.shared.dal.corba.generated.ModelCorbaHelper.write(o, value);
    }

    public org.omg.CORBA.TypeCode _type() {
        return net.vpc.gaming.atomgames.pong.main.shared.dal.corba.generated.ModelCorbaHelper.type();
    }

}
