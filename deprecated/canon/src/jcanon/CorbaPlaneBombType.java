package jcanon;


/**
* jcanon/CorbaPlaneBombType.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from /home/vpc/xprojects/games/canon/src/tn/rnu/enit/ateliercorba/jcanon/jcanon.idl
* lundi 15 octobre 2007 19 h 43 CEST
*/

public class CorbaPlaneBombType implements org.omg.CORBA.portable.IDLEntity
{
  private        int __value;
  private static int __size = 1;
  private static jcanon.CorbaPlaneBombType[] __array = new jcanon.CorbaPlaneBombType [__size];

  public static final int _SIMPLE = 0;
  public static final jcanon.CorbaPlaneBombType SIMPLE = new jcanon.CorbaPlaneBombType(_SIMPLE);

  public int value ()
  {
    return __value;
  }

  public static jcanon.CorbaPlaneBombType from_int (int value)
  {
    if (value >= 0 && value < __size)
      return __array[value];
    else
      throw new org.omg.CORBA.BAD_PARAM ();
  }

  protected CorbaPlaneBombType (int value)
  {
    __value = value;
    __array[__value] = this;
  }
} // class CorbaPlaneBombType
