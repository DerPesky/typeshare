package com.agilebits

package onepassword {

case class GenericStruct[A, B] (
	field_a: A,
	field_b: Vector[B]
)

case class UnusedGenericsStruct (
	field_a: Float,
	field_b: Float
)

case class UnusedGenericsEmptyStruct ()

case class GenericStructUsingGenericStruct[T] (
	struct_field: GenericStruct[String, T],
	second_struct_field: GenericStruct[T, String],
	third_struct_field: GenericStruct[T, Vector[T]]
)

sealed trait EnumUsingGenericStruct {
	def serialName: String
}
object EnumUsingGenericStruct {
	case class VariantA(content: GenericStruct[String, Float]) extends EnumUsingGenericStruct {
		val serialName: String = "VariantA"
	}
	case class VariantB(content: GenericStruct[String, Int]) extends EnumUsingGenericStruct {
		val serialName: String = "VariantB"
	}
	case class VariantC(content: GenericStruct[String, Boolean]) extends EnumUsingGenericStruct {
		val serialName: String = "VariantC"
	}
	case class VariantD(content: GenericStructUsingGenericStruct[Unit]) extends EnumUsingGenericStruct {
		val serialName: String = "VariantD"
	}
}

}
