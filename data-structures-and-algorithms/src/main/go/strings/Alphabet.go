package strings

var BINARY string = "01"

var DNA string = "AGCT"
var  OCTAL   string = "01234567"
var  DECIMAL   string = "0123456789"
var  HEXADECIMAL   string = "0123456789ABCDEF"
var  PROTEIN   string = "ACDEFGHIKLMNPQRSTVWY"
var  LOWERCASE   string = "abcdefghijklmnopqrstuvwxyz"
var  UPERCASE   string = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
var  BASE64   string = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"
var  ASCII   string = "128"
var  EXTENDED_ASCII   string = "256"
var  UNICODE16   string = "65536"


type Alphabet interface {

	toChar(index int) uint16

	toIndex(c uint16) int

	contains(c uint16) bool

	//基数（字母表中的字符数量）
	R() int

	//表示一个索引所需的比特数
	lgR() int

	//将s转换为R进制的整数
	toIndices(s string) []int

	toChars(indices []int) string

}

type Alphabets struct {
	R int
	alphabet []uint16
	indices [] int
}

func NewAlphabets() *Alphabets {
    return newAlphabets(256)
}

func newAlphabets(radix int) *Alphabets {
    var result = new(Alphabets)
    result.R = radix
	var chararray  = [256]uint16{}
	result.alphabet = chararray

	var indicesArray = [256]int16{}

    result.indices = indicesArray
   var i int = 0
    for i =0; i<radix ; i++{
		result.alphabet[i] =
	}

	return result
}

func(alphabet Alphabets) toChar(index int) uint16{
	return uint16(0)
}

func(alphabet Alphabets) toIndex(char uint16) int{
	return int(0)
}

func(alphabet Alphabets) cotains(char uint16) bool{
	return bool(false)
}

func(alphabet Alphabets) Rs() int{
	return int(0)
}

func(alphabet Alphabets) lgR() int{
	return int(0)
}

func(alphabet Alphabets) toIndices(s string) []int{
	return []int{}
}

func(alphabet Alphabets) toChars(indices []int) string{
	return string("")
}

