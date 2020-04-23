#pragma once
#include <iostream>

namespace list
{
	template <typename T>
	class LinkedList
	{
	public:
		template <typename T>
		struct Element
		{
			T value;
			Element *next;
			Element *previous;

			Element(T value)
			{
				this->value = value;
				this->next = nullptr;
				this->previous = nullptr;
			}
		};
		LinkedList()
		{
			head = nullptr;
			tail = nullptr;
			length = 0;
		}

		LinkedList(T value)
		{
			head = new Element<T>(value);
			tail = head;
			length = 1;
		}

		~LinkedList()
		{
			while (head != nullptr)
			{
				Element<T> *next = head->next;
				delete head;
				head = next;
			}
		}

		std::size_t getLength()
		{
			return length;
		}

		Element<T>* getHead()
		{
			return head;
		}

		Element<T>* getTail()
		{
			return tail;
		}

		Element<T>* get(std::size_t index)
		{
			if (index < 0)
			{
				throw "Negative index: " + index;
			}
			std::size_t count = 0;
			Element<T> *element = head;
			while (element != nullptr)
			{
				if (count == index)
				{
					return element;
				}
				count++;
				element = element->next;
			}
			throw "Index out of bounds: " + index;
		}

		std::size_t indexOf(Element<T> *element)
		{
			Element<T> *current = head;
			std::size_t count = 0;
			while (current != nullptr)
			{
				if (current == element)
				{
					return count;
				}
				count++;
			}
			return -1;
		}

		std::size_t indexOf(T value)
		{
			Element<T> *current = head;
			std::size_t count = 0;
			while (current != nullptr)
			{
				if (current->value == value)
				{
					return count;
				}
				count++;
			}
			return -1;
		}

		Element<T>* addFirst(T value)
		{
			Element<T> *newHead = new Element<T>(value);
			if (head == nullptr)
			{
				tail = newHead;
			} 
			else
			{
				newHead->next = head;
				head->previous = newHead;
			}
			head = newHead;
			length++;
			return head;
		}

		Element<T>* addLast(T value)
		{
			Element<T> *newTail = new Element<T>(value);
			if (tail == nullptr)
			{
				head = newTail;
			}
			else 
			{
				newTail->previous = tail;
				tail->next = newTail;
			}
			tail = newTail;
			length++;
			return tail;
		}

		void removeFirst()
		{
			if (head != nullptr)
			{
				if (tail == head)
				{
					tail = nullptr;
				}
				Element<T> *next = head->next;
				if (next != nullptr)
				{
					next->previous = nullptr;
				}
				delete head;
				head = next;
				length--;
			}
		}

		void removeLast()
		{
			if (tail == head)
			{
				removeFirst();
			}
			else
			{
				Element<T> *previousElement = tail->previous;
				previousElement->next = nullptr; // safe
				delete tail;
				tail = previousElement;
				length--;
			}
		}

		void remove(std::size_t index)
		{
			Element<T> *element = get(index);
			remove(element);
		}

		void remove(Element<T> *element)
		{
			if (element == head)
			{
				removeFirst();
			}
			else if (element == tail)
			{
				removeLast();
			}
			else
			{
				Element<T> *previousElement = element->previous;
				Element<T> *nextElement = element->next;
				previousElement->next = nextElement; // safe
				nextElement->previous = previousElement; // safe
				delete element;
				length--;
			}
		}

		friend std::ostream& operator<<(std::ostream& stream, LinkedList<T>& list)
		{
			Element<T> *current = list.head;
			while (current != nullptr)
			{
				stream << current->value << ' ';
				current = current->next;
			}
			return stream;
		}
		private:
			Element<T> *head;
			Element<T> *tail;
			std::size_t length;
	};
}