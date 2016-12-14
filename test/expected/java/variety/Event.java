/**
 * Autogenerated by Frugal Compiler (2.0.0-RC5)
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *
 * @generated
 */
package variety.java;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This docstring gets added to the generated code because it has
 * the @ sign.
 */
@Generated(value = "Autogenerated by Frugal Compiler (2.0.0-RC5)", date = "2015-11-24")
public class Event implements org.apache.thrift.TBase<Event, Event._Fields>, java.io.Serializable, Cloneable, Comparable<Event> {
	private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Event");

	private static final org.apache.thrift.protocol.TField ID_FIELD_DESC = new org.apache.thrift.protocol.TField("ID", org.apache.thrift.protocol.TType.I64, (short)1);
	private static final org.apache.thrift.protocol.TField MESSAGE_FIELD_DESC = new org.apache.thrift.protocol.TField("Message", org.apache.thrift.protocol.TType.STRING, (short)2);

	private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
	static {
		schemes.put(StandardScheme.class, new EventStandardSchemeFactory());
		schemes.put(TupleScheme.class, new EventTupleSchemeFactory());
	}

	/**
	 * ID is a unique identifier for an event.
	 */
	public long ID; // required
	/**
	 * Message contains the event payload.
	 */
	public String Message; // required
	/** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
	public enum _Fields implements org.apache.thrift.TFieldIdEnum {
		/**
		 * ID is a unique identifier for an event.
		 */
		ID((short)1, "ID"),
		/**
		 * Message contains the event payload.
		 */
		MESSAGE((short)2, "Message")
;

		private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

		static {
			for (_Fields field : EnumSet.allOf(_Fields.class)) {
				byName.put(field.getFieldName(), field);
			}
		}

		/**
		 * Find the _Fields constant that matches fieldId, or null if its not found.
		 */
		public static _Fields findByThriftId(int fieldId) {
			switch(fieldId) {
				case 1: // ID
					return ID;
				case 2: // MESSAGE
					return MESSAGE;
				default:
					return null;
			}
		}

		/**
		 * Find the _Fields constant that matches fieldId, throwing an exception
		 * if it is not found.
		 */
		public static _Fields findByThriftIdOrThrow(int fieldId) {
			_Fields fields = findByThriftId(fieldId);
			if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
			return fields;
		}

		/**
		 * Find the _Fields constant that matches name, or null if its not found.
		 */
		public static _Fields findByName(String name) {
			return byName.get(name);
		}

		private final short _thriftId;
		private final String _fieldName;

		_Fields(short thriftId, String fieldName) {
			_thriftId = thriftId;
			_fieldName = fieldName;
		}

		public short getThriftFieldId() {
			return _thriftId;
		}

		public String getFieldName() {
			return _fieldName;
		}
	}

	// isset id assignments
	private static final int __ID_ISSET_ID = 0;
	private byte __isset_bitfield = 0;
	public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
	static {
		Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
		tmpMap.put(_Fields.ID, new org.apache.thrift.meta_data.FieldMetaData("ID", org.apache.thrift.TFieldRequirementType.DEFAULT,
				new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64, "id")));
		tmpMap.put(_Fields.MESSAGE, new org.apache.thrift.meta_data.FieldMetaData("Message", org.apache.thrift.TFieldRequirementType.DEFAULT,
				new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
		metaDataMap = Collections.unmodifiableMap(tmpMap);
		org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Event.class, metaDataMap);
	}

	public Event() {
		this.ID = varietyConstants.DEFAULT_ID;

	}

	public Event(
		long ID,
		String Message) {
		this();
		this.ID = ID;
		setIDIsSet(true);
		this.Message = Message;
	}

	/**
	 * Performs a deep copy on <i>other</i>.
	 */
	public Event(Event other) {
		__isset_bitfield = other.__isset_bitfield;
		this.ID = other.ID;
		if (other.isSetMessage()) {
			this.Message = other.Message;
		}
	}

	public Event deepCopy() {
		return new Event(this);
	}

	@Override
	public void clear() {
		this.ID = varietyConstants.DEFAULT_ID;

		this.Message = null;

	}

	/**
	 * ID is a unique identifier for an event.
	 */
	public long getID() {
		return this.ID;
	}

	/**
	 * ID is a unique identifier for an event.
	 */
	public Event setID(long ID) {
		this.ID = ID;
		setIDIsSet(true);
		return this;
	}

	public void unsetID() {
		__isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ID_ISSET_ID);
	}

	/** Returns true if field ID is set (has been assigned a value) and false otherwise */
	public boolean isSetID() {
		return EncodingUtils.testBit(__isset_bitfield, __ID_ISSET_ID);
	}

	public void setIDIsSet(boolean value) {
		__isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ID_ISSET_ID, value);
	}

	/**
	 * Message contains the event payload.
	 */
	public String getMessage() {
		return this.Message;
	}

	/**
	 * Message contains the event payload.
	 */
	public Event setMessage(String Message) {
		this.Message = Message;
		return this;
	}

	public void unsetMessage() {
		this.Message = null;
	}

	/** Returns true if field Message is set (has been assigned a value) and false otherwise */
	public boolean isSetMessage() {
		return this.Message != null;
	}

	public void setMessageIsSet(boolean value) {
		if (!value) {
			this.Message = null;
		}
	}

	public void setFieldValue(_Fields field, Object value) {
		switch (field) {
		case ID:
			if (value == null) {
				unsetID();
			} else {
				setID((Long)value);
			}
			break;

		case MESSAGE:
			if (value == null) {
				unsetMessage();
			} else {
				setMessage((String)value);
			}
			break;

		}
	}

	public Object getFieldValue(_Fields field) {
		switch (field) {
		case ID:
			return getID();

		case MESSAGE:
			return getMessage();

		}
		throw new IllegalStateException();
	}

	/** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
	public boolean isSet(_Fields field) {
		if (field == null) {
			throw new IllegalArgumentException();
		}

		switch (field) {
		case ID:
			return isSetID();
		case MESSAGE:
			return isSetMessage();
		}
		throw new IllegalStateException();
	}

	@Override
	public boolean equals(Object that) {
		if (that == null)
			return false;
		if (that instanceof Event)
			return this.equals((Event)that);
		return false;
	}

	public boolean equals(Event that) {
		if (that == null)
			return false;

		boolean this_present_ID = true;
		boolean that_present_ID = true;
		if (this_present_ID || that_present_ID) {
			if (!(this_present_ID && that_present_ID))
				return false;
			if (this.ID != that.ID)
				return false;
		}

		boolean this_present_Message = true && this.isSetMessage();
		boolean that_present_Message = true && that.isSetMessage();
		if (this_present_Message || that_present_Message) {
			if (!(this_present_Message && that_present_Message))
				return false;
			if (!this.Message.equals(that.Message))
				return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		List<Object> list = new ArrayList<Object>();

		boolean present_ID = true;
		list.add(present_ID);
		if (present_ID)
			list.add(ID);

		boolean present_Message = true && (isSetMessage());
		list.add(present_Message);
		if (present_Message)
			list.add(Message);

		return list.hashCode();
	}

	@Override
	public int compareTo(Event other) {
		if (!getClass().equals(other.getClass())) {
			return getClass().getName().compareTo(other.getClass().getName());
		}

		int lastComparison = 0;

		lastComparison = Boolean.valueOf(isSetID()).compareTo(other.isSetID());
		if (lastComparison != 0) {
			return lastComparison;
		}
		if (isSetID()) {
			lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.ID, other.ID);
			if (lastComparison != 0) {
				return lastComparison;
			}
		}
		lastComparison = Boolean.valueOf(isSetMessage()).compareTo(other.isSetMessage());
		if (lastComparison != 0) {
			return lastComparison;
		}
		if (isSetMessage()) {
			lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.Message, other.Message);
			if (lastComparison != 0) {
				return lastComparison;
			}
		}
		return 0;
	}

	public _Fields fieldForId(int fieldId) {
		return _Fields.findByThriftId(fieldId);
	}

	public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
		schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
	}

	public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
		schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Event(");
		boolean first = true;

		sb.append("ID:");
		sb.append(this.ID);
		first = false;
		if (!first) sb.append(", ");
		sb.append("Message:");
		if (this.Message == null) {
			sb.append("null");
		} else {
			sb.append(this.Message);
		}
		first = false;
		sb.append(")");
		return sb.toString();
	}

	public void validate() throws org.apache.thrift.TException {
		// check for required fields
		// check for sub-struct validity
	}

	private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
		try {
			write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
		} catch (org.apache.thrift.TException te) {
			throw new java.io.IOException(te);
		}
	}

	private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
		try {
			// it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
			__isset_bitfield = 0;
			read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
		} catch (org.apache.thrift.TException te) {
			throw new java.io.IOException(te);
		}
	}

	private static class EventStandardSchemeFactory implements SchemeFactory {
		public EventStandardScheme getScheme() {
			return new EventStandardScheme();
		}
	}

	private static class EventStandardScheme extends StandardScheme<Event> {

		public void read(org.apache.thrift.protocol.TProtocol iprot, Event struct) throws org.apache.thrift.TException {
			org.apache.thrift.protocol.TField schemeField;
			iprot.readStructBegin();
			while (true) {
				schemeField = iprot.readFieldBegin();
				if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
					break;
				}
				switch (schemeField.id) {
					case 1: // ID
						if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
							struct.ID = iprot.readI64();
							struct.setIDIsSet(true);
						} else {
							org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
						}
						break;
					case 2: // MESSAGE
						if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
							struct.Message = iprot.readString();
							struct.setMessageIsSet(true);
						} else {
							org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
						}
						break;
					default:
						org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
				}
				iprot.readFieldEnd();
			}
			iprot.readStructEnd();

			// check for required fields of primitive type, which can't be checked in the validate method
			struct.validate();
		}

		public void write(org.apache.thrift.protocol.TProtocol oprot, Event struct) throws org.apache.thrift.TException {
			struct.validate();

			oprot.writeStructBegin(STRUCT_DESC);
			oprot.writeFieldBegin(ID_FIELD_DESC);
			oprot.writeI64(struct.ID);
			oprot.writeFieldEnd();
			if (struct.Message != null) {
				oprot.writeFieldBegin(MESSAGE_FIELD_DESC);
				oprot.writeString(struct.Message);
				oprot.writeFieldEnd();
			}
			oprot.writeFieldStop();
			oprot.writeStructEnd();
		}

	}

	private static class EventTupleSchemeFactory implements SchemeFactory {
		public EventTupleScheme getScheme() {
			return new EventTupleScheme();
		}
	}

	private static class EventTupleScheme extends TupleScheme<Event> {

		@Override
		public void write(org.apache.thrift.protocol.TProtocol prot, Event struct) throws org.apache.thrift.TException {
			TTupleProtocol oprot = (TTupleProtocol) prot;
			BitSet optionals = new BitSet();
			if (struct.isSetID()) {
				optionals.set(0);
			}
			if (struct.isSetMessage()) {
				optionals.set(1);
			}
			oprot.writeBitSet(optionals, 2);
			if (struct.isSetID()) {
				oprot.writeI64(struct.ID);
			}
			if (struct.isSetMessage()) {
				oprot.writeString(struct.Message);
			}
		}

		@Override
		public void read(org.apache.thrift.protocol.TProtocol prot, Event struct) throws org.apache.thrift.TException {
			TTupleProtocol iprot = (TTupleProtocol) prot;
			BitSet incoming = iprot.readBitSet(2);
			if (incoming.get(0)) {
				struct.ID = iprot.readI64();
				struct.setIDIsSet(true);
			}
			if (incoming.get(1)) {
				struct.Message = iprot.readString();
				struct.setMessageIsSet(true);
			}
		}

	}

}
