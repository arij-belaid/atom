package jcanon;


/**
* jcanon/CorbaPlaneType.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from /home/vpc/xprojects/games/canon/src/tn/rnu/enit/ateliercorba/jcanon/jcanon.idl
* lundi 15 octobre 2007 19 h 43 CEST
*/

public class CorbaPlaneType implements org.omg.CORBA.portable.IDLEntity
{
  private        int __value;
  private static int __size = 2;
  private static jcanon.CorbaPlaneType[] __array = new jcanon.CorbaPlaneType [__size];

  public static final int _ONE = 0;
  public static final jcanon.CorbaPlaneType ONE = new jcanon.CorbaPlaneType(_ONE);
  public static final int _TWO = 1;
  public static final jcanon.CorbaPlaneType TWO = new jcanon.CorbaPlaneType(_TWO);

  public int value ()
  {
    return __value;
  }

  public static jcanon.CorbaPlaneType from_int (int value)
  {
    if (value >= 0 && value < __size)
      return __array[value];
    else
      throw new org.omg.CORBA.BAD_PARAM ();
  }

  protected CorbaPlaneType (int value)
  {
    __value = value;
    __array[__value] = this;
  }
} // class CorbaPlaneType
